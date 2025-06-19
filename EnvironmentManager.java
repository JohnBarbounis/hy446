import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class EnvironmentManager {
    private final Stack<Map<String, Integer>> scopes = new Stack<>();

    public EnvironmentManager() {
        // Initialize with a global scope
        pushScope();
    }

    public void pushScope() {
        scopes.push(new HashMap<>());
    }

    public void popScope() {
        if (scopes.size() <= 1) {
            throw new IllegalStateException("Cannot pop the global scope.");
        }
        scopes.pop();
    }

    public void declare(String name, Integer address) {
        // Declares a variable in the current (top-most) scope.
        scopes.peek().put(name, address);
    }

    public void assign(String name, Integer address) {
        // Assigns to an existing variable, searching from current scope downwards.
        for (int i = scopes.size() - 1; i >= 0; i--) {
            if (scopes.get(i).containsKey(name)) {
                scopes.get(i).put(name, address);
                return;
            }
        }
        throw new RuntimeException("Runtime Error: Variable '" + name + "' is not declared.");
    }

    public Integer lookup(String name) {
        // Looks up a variable's address, searching from current scope downwards.
        for (int i = scopes.size() - 1; i >= 0; i--) {
            if (scopes.get(i).containsKey(name)) {
                return scopes.get(i).get(name);
            }
        }
        throw new RuntimeException("Runtime Error: Variable '" + name + "' is not declared.");
    }

    /**
     * This is the key method for the GC. It gathers all variable addresses
     * from all active scopes to use as the root set.
     */
    public Collection<Integer> getAllActiveRoots() {
        return scopes.stream()
                .flatMap(scope -> scope.values().stream())
                .collect(Collectors.toList());
    }

    /**
     * Gathers information about all visible variables, including their scope level.
     * 
     * @return A map from variable name to a VariableInfo record.
     */
    public Map<String, VariableInfo> getVisibleVariableInfo() {
        Map<String, VariableInfo> visible = new HashMap<>();
        // Iterate from the current scope (top of stack) down to global.
        for (int i = scopes.size() - 1; i >= 0; i--) {
            int scopeLevel = i;
            scopes.get(i).forEach((name, address) -> {
                // Add the variable if it hasn't been seen yet (handles shadowing).
                if (!visible.containsKey(name)) {
                    visible.put(name, new VariableInfo(address, scopeLevel));
                }
            });
        }
        return visible;
    }
}