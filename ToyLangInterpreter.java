import java.util.LinkedHashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToyLangInterpreter extends ToyLangBaseVisitor<Integer> {
    private final Heap heap = new Heap();
    private final GarbageCollector gc = new GarbageCollector(heap);
    private final EnvironmentManager envManager = new EnvironmentManager();
    private long totalGCPauseTimeNs = 0;
    private final List<Long> gcPauseDurations = new ArrayList<>();

    // --- NEW FIELD ---
    // Accumulator for total GC pause time in nanoseconds.

    // Add this method back into the class
    public Heap getHeap() {
        return heap;
    }

    // Helper method to run the GC
    public void runGC() {
        System.out.println("\n--- Heap State Before Garbage Collection ---");
        visualizeHeap();

        System.out.println("\n--- Triggering Garbage Collection ---");

        // --- BENCHMARKING CODE ---
        // 1. Get state before the run
        int heapSizeBefore = heap.getMemory().size();
        long startTime = System.nanoTime();

        // 2. Run the actual garbage collector
        gc.run(envManager.getAllActiveRoots(), envManager.getVisibleVariableInfo());

        // 3. Get state after the run
        long endTime = System.nanoTime();
        int heapSizeAfter = heap.getMemory().size();
        // --- END BENCHMARKING CODE ---

        // 4. Calculate and print the results
        int collectedCount = heapSizeBefore - heapSizeAfter;
        long durationNs = endTime - startTime;
        double durationMs = durationNs / 1_000_000.0;

        // --- UPDATE ---
        // Add the duration of this pause to the total and the list.
        this.totalGCPauseTimeNs += durationNs;
        this.gcPauseDurations.add(durationNs);

        System.out.printf(
                "\nGC_BENCHMARK: Paused for %,d ns (%.2f ms). Collected %d objects.\n",
                durationNs,
                durationMs,
                collectedCount);

        System.out.println("\n--- Heap State After Garbage Collection ---");
        visualizeHeap();
    }

    @Override
    public Integer visitProgram(ToyLangParser.ProgramContext ctx) {
        for (ToyLangParser.StatementContext statementCtx : ctx.statement()) {
            visit(statementCtx);
            // Check if the heap has grown enough to trigger a collection.
            if (heap.needsCollection()) {
                System.out.println("\n--- Heap threshold reached, automatically triggering GC ---");
                runGC();
            }
        }
        return null;
    }

    @Override
    public Integer visitVarDecl(ToyLangParser.VarDeclContext ctx) {
        String varName = ctx.ID().getText();
        Integer address = visit(ctx.expression());
        envManager.declare(varName, address);
        return null;
    }

    @Override
    public Integer visitAssignment(ToyLangParser.AssignmentContext ctx) {
        String varName = ctx.ID().getText();
        Integer address = visit(ctx.expression());
        envManager.assign(varName, address); // Use assign
        return null;
    }

    @Override
    public Integer visitAddSubExpr(ToyLangParser.AddSubExprContext ctx) {
        ToyLangValue left = heap.get(visit(ctx.expression(0)));
        ToyLangValue right = heap.get(visit(ctx.expression(1)));

        if (!(left instanceof ToyLangNumber) || !(right instanceof ToyLangNumber)) {
            throw new RuntimeException("Runtime Error: Arithmetic operations require integer operands.");
        }

        int leftVal = ((ToyLangNumber) left).getValue();
        int rightVal = ((ToyLangNumber) right).getValue();
        int result;

        if (ctx.op.getText().equals("+")) {
            result = leftVal + rightVal;
        } else {
            result = leftVal - rightVal;
        }
        return heap.allocate(new ToyLangNumber(result));
    }

    @Override
    public Integer visitMulDivExpr(ToyLangParser.MulDivExprContext ctx) {
        ToyLangValue left = heap.get(visit(ctx.expression(0)));
        ToyLangValue right = heap.get(visit(ctx.expression(1)));

        if (!(left instanceof ToyLangNumber) || !(right instanceof ToyLangNumber)) {
            throw new RuntimeException("Runtime Error: Arithmetic operations require integer operands.");
        }

        int leftVal = ((ToyLangNumber) left).getValue();
        int rightVal = ((ToyLangNumber) right).getValue();
        int result;

        if (ctx.op.getText().equals("*")) {
            result = leftVal * rightVal;
        } else {
            if (rightVal == 0) {
                throw new RuntimeException("Runtime Error: Division by zero.");
            }
            result = leftVal / rightVal;
        }
        return heap.allocate(new ToyLangNumber(result));
    }

    @Override
    public Integer visitAtomExpr(ToyLangParser.AtomExprContext ctx) {
        return visit(ctx.atom());
    }

    @Override
    public Integer visitParenExpr(ToyLangParser.ParenExprContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Integer visitNumberAtom(ToyLangParser.NumberAtomContext ctx) {
        int value = Integer.parseInt(ctx.getText());
        return heap.allocate(new ToyLangNumber(value));
    }

    @Override
    public Integer visitStringAtom(ToyLangParser.StringAtomContext ctx) {
        String text = ctx.getText();
        String value = text.substring(1, text.length() - 1);
        return heap.allocate(new ToyLangString(value));
    }

    @Override
    public Integer visitIdAtom(ToyLangParser.IdAtomContext ctx) {
        return envManager.lookup(ctx.getText()); // Use lookup
    }

    @Override
    public Integer visitObjectAtom(ToyLangParser.ObjectAtomContext ctx) {
        // 1. Allocate a new, empty object on the heap.
        ToyLangObject newObject = new ToyLangObject();
        Integer objectAddress = heap.allocate(newObject);

        // 2. Visit each property pair, evaluate its expression, and set it on the new
        // object.
        for (ToyLangParser.PairContext pairCtx : ctx.pair()) {
            String key = pairCtx.STRING().getText();
            key = key.substring(1, key.length() - 1); // Remove quotes

            Integer valueAddress = visit(pairCtx.expression());
            newObject.setProperty(key, valueAddress);
        }
        return objectAddress;
    }

    @Override
    public Integer visitNullAtom(ToyLangParser.NullAtomContext ctx) {
        return heap.allocate(new ToyLangNull());
    }

    // Getters for Main to inspect the state
    public Map<String, Integer> getEnvironment() {
        // Convert the richer VariableInfo map into the simple map that Main expects.
        return envManager.getVisibleVariableInfo().entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().address()));
    }

    // --- NEW GETTER ---
    public List<Long> getGcPauseDurations() {
        return gcPauseDurations;
    }

    /**
     * Returns the total accumulated time spent in garbage collection pauses.
     * 
     * @return Total pause time in nanoseconds.
     */
    public long getTotalGCPauseTimeNs() {
        return this.totalGCPauseTimeNs;
    }

    // --- NEW METHOD ---
    /**
     * Prints the final state of all variables in the global scope.
     * This is useful for verifying the end result of a script.
     */
    public void printFinalEnvironmentState() {
        envManager.getVisibleVariableInfo().entrySet().stream()
                .sorted(java.util.Map.Entry.comparingByKey()) // Sort for consistent output
                .forEach(entry -> {
                    String varName = entry.getKey();
                    VariableInfo info = entry.getValue();
                    ToyLangValue value = heap.get(info.address());
                    System.out.printf("%s (addr: 0x%X) = %s\n", varName, info.address(), value.toString());
                });
    }

    // Helper method to visualize the heap
    public void visualizeHeap() {
        Map<String, VariableInfo> visibleVarInfo = envManager.getVisibleVariableInfo();
        Map<Integer, String> addressToVarName = visibleVarInfo.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getValue().address(), Map.Entry::getKey, (e, n) -> e));
        Map<Integer, Integer> addressToScopeLevel = visibleVarInfo.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getValue().address(), e -> e.getValue().scopeLevel(), (e, n) -> e));
        heap.visualize(addressToVarName, addressToScopeLevel);
    }

    @Override
    public Integer visitBlockStatement(ToyLangParser.BlockStatementContext ctx) {
        // Entering a new block, so we create a new, deeper scope.
        envManager.pushScope();
        try {
            // Execute all the statements within the block.
            visit(ctx.program());
        } finally {
            // Exiting the block, so we destroy its scope.
            // This is in a 'finally' block to ensure it always runs.
            envManager.popScope();
        }
        // A block statement itself does not produce a value.
        return null;
    }

    @Override
    public Integer visitFunctionDecl(ToyLangParser.FunctionDeclContext ctx) {
        List<String> params = new ArrayList<>();
        if (ctx.idList() != null) {
            for (var id : ctx.idList().ID()) {
                params.add(id.getText());
            }
        }
        ToyLangFunction func = new ToyLangFunction(params, ctx.program());
        Integer address = heap.allocate(func);
        envManager.declare(ctx.ID().getText(), address);
        return null;
    }

    @Override
    public Integer visitExprStatement(ToyLangParser.ExprStatementContext ctx) {
        // Allows for function calls as standalone statements (e.g., "myFunc();")
        visit(ctx.expression());
        return null;
    }

    @Override
    public Integer visitReturnStatement(ToyLangParser.ReturnStatementContext ctx) {
        Integer returnValueAddress = null;
        if (ctx.expression() != null) {
            returnValueAddress = visit(ctx.expression());
        } else {
            // return; is the same as return null;
            returnValueAddress = heap.allocate(new ToyLangNull());
        }
        throw new ReturnException(returnValueAddress);
    }

    @Override
    public Integer visitFunctionCallExpr(ToyLangParser.FunctionCallExprContext ctx) {
        // 1. Look up the function object
        String funcName = ctx.ID().getText();
        Integer funcAddress = envManager.lookup(funcName);
        ToyLangValue funcValue = heap.get(funcAddress);

        if (!(funcValue instanceof ToyLangFunction)) {
            throw new RuntimeException("Runtime Error: '" + funcName + "' is not a function.");
        }
        ToyLangFunction function = (ToyLangFunction) funcValue;

        // 2. Evaluate arguments
        List<Integer> argAddresses = new ArrayList<>();
        if (ctx.exprList() != null) {
            for (var expr : ctx.exprList().expression()) {
                argAddresses.add(visit(expr));
            }
        }

        if (argAddresses.size() != function.getParameters().size()) {
            throw new RuntimeException("Runtime Error: Function '" + funcName + "' expected "
                    + function.getParameters().size() + " arguments but got " + argAddresses.size());
        }

        // 3. Create a new scope for the function call
        envManager.pushScope();

        // 4. Declare arguments as variables in the new scope
        for (int i = 0; i < function.getParameters().size(); i++) {
            envManager.declare(function.getParameters().get(i), argAddresses.get(i));
        }

        // 5. Execute the function body
        Integer returnValueAddress;
        try {
            visit(function.getBody());
            // If no return statement is hit, the function implicitly returns null
            returnValueAddress = heap.allocate(new ToyLangNull());
        } catch (ReturnException e) {
            // Catch the return value
            returnValueAddress = e.returnValueAddress;
        }

        // 6. Destroy the function's scope
        envManager.popScope();

        return returnValueAddress;
    }

    // --- Implement Control Flow ---

    @Override
    public Integer visitIfStatement(ToyLangParser.IfStatementContext ctx) {
        Integer conditionAddress = visit(ctx.expression());
        ToyLangValue conditionValue = heap.get(conditionAddress);

        if (conditionValue.isTruthy()) {
            visit(ctx.program(0)); // Visit the 'then' block
        } else if (ctx.program(1) != null) { // Check if an 'else' block exists
            visit(ctx.program(1)); // Visit the 'else' block
        }
        return null;
    }

    @Override
    public Integer visitWhileStatement(ToyLangParser.WhileStatementContext ctx) {
        while (true) {
            Integer conditionAddress = visit(ctx.expression());
            ToyLangValue conditionValue = heap.get(conditionAddress);

            if (conditionValue.isTruthy()) {
                visit(ctx.program());
            } else {
                break; // Exit the loop
            }
        }
        return null;
    }

    // --- Implement Boolean Logic ---

    @Override
    public Integer visitTrueAtom(ToyLangParser.TrueAtomContext ctx) {
        return heap.allocate(new ToyLangBoolean(true));
    }

    @Override
    public Integer visitFalseAtom(ToyLangParser.FalseAtomContext ctx) {
        return heap.allocate(new ToyLangBoolean(false));
    }

    @Override
    public Integer visitEqualityExpr(ToyLangParser.EqualityExprContext ctx) {
        Integer leftAddr = visit(ctx.expression(0));
        Integer rightAddr = visit(ctx.expression(1));
        ToyLangValue left = heap.get(leftAddr);
        ToyLangValue right = heap.get(rightAddr);

        // Simple equality check for now. Can be expanded for type coercion.
        boolean result = left.getValue().equals(right.getValue());
        if (ctx.op.getType() == ToyLangParser.NEQ) { // '!='
            result = !result;
        }
        return heap.allocate(new ToyLangBoolean(result));
    }

    @Override
    public Integer visitCompareExpr(ToyLangParser.CompareExprContext ctx) {
        Integer leftAddr = visit(ctx.expression(0));
        Integer rightAddr = visit(ctx.expression(1));
        ToyLangValue left = heap.get(leftAddr);
        ToyLangValue right = heap.get(rightAddr);

        // This implementation assumes comparison between numbers.
        if (!(left instanceof ToyLangNumber) || !(right instanceof ToyLangNumber)) {
            throw new RuntimeException("Comparison operators can only be used on numbers.");
        }

        double leftNum = ((ToyLangNumber) left).getValue();
        double rightNum = ((ToyLangNumber) right).getValue();
        boolean result = false;

        switch (ctx.op.getType()) {
            case ToyLangParser.LT:
                result = leftNum < rightNum;
                break;
            case ToyLangParser.GT:
                result = leftNum > rightNum;
                break;
            case ToyLangParser.LTEQ:
                result = leftNum <= rightNum;
                break;
            case ToyLangParser.GTEQ:
                result = leftNum >= rightNum;
                break;
        }
        return heap.allocate(new ToyLangBoolean(result));
    }
}