import java.util.Map;
import java.util.stream.Collectors;
import java.util.Collection;

public class GarbageCollector {
    private final Heap heap;

    public GarbageCollector(Heap heap) {
        this.heap = heap;
    }

    private void mark(int address) {
        ToyLangValue value = heap.get(address);
        if (value == null || value.marked) {
            return; // Already visited or null reference
        }

        value.marked = true;
        System.out.println("GC:  -> Marked object at " + String.format("0x%X", address) + " ("
                + value.getClass().getSimpleName() + ")");

        // --- RECURSIVE MARKING IMPROVEMENT ---
        // If the value is an object, we must also mark all objects it references.
        if (value instanceof ToyLangObject) {
            System.out.println("GC:  -> Traversing properties of object at " + String.format("0x%X", address));
            ToyLangObject obj = (ToyLangObject) value;
            for (Integer propertyAddress : obj.getProperties().values()) {
                mark(propertyAddress); // Recursively mark children
            }
        }
    }

    /**
     * The run method now accepts the roots (for marking) and the visible
     * environment (for visualization).
     * 
     * @param roots              A collection of all root addresses from all active
     *                           scopes.
     * @param visibleEnvironment A map of all visible variable names to their
     *                           addresses.
     */
    public void run(Collection<Integer> roots, Map<String, VariableInfo> visibleVarInfo) {
        System.out.println("GC: === Starting Mark and Sweep ===");
        System.out.println("GC: Identifying roots from all active scopes...");

        for (Integer rootAddress : roots) {
            mark(rootAddress);
        }

        System.out.println("GC: Mark phase complete.");

        // --- UPDATED VISUALIZATION ---
        System.out.println("\n--- Heap State After Mark Phase (Before Sweep) ---");
        // Create the maps needed for the new visualize method
        Map<Integer, String> addressToVarName = visibleVarInfo.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getValue().address(), Map.Entry::getKey, (e, n) -> e));
        Map<Integer, Integer> addressToScopeLevel = visibleVarInfo.entrySet().stream()
                .collect(Collectors.toMap(e -> e.getValue().address(), e -> e.getValue().scopeLevel(), (e, n) -> e));
        heap.visualize(addressToVarName, addressToScopeLevel);
        // --- END OF VISUALIZATION ---

        heap.sweep();
        System.out.println("GC: === Garbage Collection Finished ===");
    }
}