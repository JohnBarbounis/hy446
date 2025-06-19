import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Heap {
    private final Map<Integer, ToyLangValue> memory = new HashMap<>();
    private int nextAddress = 0;

    // --- NEW ADAPTIVE GC FIELDS ---
    // The number of live objects after the last GC cycle.
    private int heapSizeAfterLastGC = 0;
    // The heap size that will trigger the next GC.
    private int nextGCTriggerSize = 10; // Start with a small initial threshold.
    // The tunable factor. 2.0 means we let the heap double in size before
    // collecting.
    private static final double HEAP_GROWTH_FACTOR = 2.0;

    public int allocate(ToyLangValue value) {
        int address = nextAddress++;
        memory.put(address, value);
        // We no longer print the allocation message here to reduce console noise.
        // It can be re-enabled for debugging if needed.
        return address;
    }

    /**
     * The core logic for the adaptive trigger.
     */
    public boolean needsCollection() {
        // We use the number of objects as a proxy for byte size in our simulation.
        return memory.size() >= nextGCTriggerSize;
    }

    public ToyLangValue get(int address) {
        return memory.get(address);
    }

    public void sweep() {
        System.out.println("GC: --- Starting Sweep Phase ---");
        System.out.println("GC: Heap state before sweep (" + memory.size() + " objects total):");
        System.out.println("GC: Final heap size: " + memory.size() + " objects.");
        // Print all objects and their marked status for debugging
        memory.forEach((addr, val) -> System.out.println(
                "GC:   - Address " + String.format("0x%X", addr) + ": " + val + " (Marked: " + val.marked + ")"));

        // Identify all unmarked (garbage) objects
        List<Integer> garbageAddresses = memory.entrySet().stream()
                .filter(entry -> !entry.getValue().marked)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("GC: Sweeping " + garbageAddresses.size() + " garbage objects...");
        for (Integer addr : garbageAddresses) {
            ToyLangValue val = memory.get(addr);
            System.out.println("GC:   -> Sweeping object at " + String.format("0x%X", addr) + ": " + val);
            memory.remove(addr);
        }

        System.out.println("GC: Resetting marks on " + memory.size() + " live objects for next cycle.");
        // Reset marks on all surviving objects for the next GC cycle
        memory.values().forEach(val -> {
            if (val.marked) { // This will be true for all remaining objects
                val.marked = false;
            }
        });

        System.out.println("GC: --- Sweep Phase Finished ---");
        System.out.println("GC: Final heap size: " + memory.size() + " objects.");

        // --- THE FEEDBACK LOOP ---
        // After sweeping, update our state for the next cycle.
        this.heapSizeAfterLastGC = memory.size();
        this.nextGCTriggerSize = (int) (this.heapSizeAfterLastGC * HEAP_GROWTH_FACTOR) + 10; // Add a small base
        System.out.println("GC: Next collection will trigger at " + this.nextGCTriggerSize + " objects.");
    }

    public Map<Integer, ToyLangValue> getMemory() {
        return memory;
    }

    /**
     * Prints a text-based visualization of the current heap state to the console.
     * 
     * @param addressToVarName A map where the key is the memory address and the
     *                         value
     *                         is the name of the variable pointing to it.
     */
    /**
     * Prints a text-based visualization of the current heap state to the console.
     * 
     * @param addressToVarName    A map from address to the variable name pointing
     *                            to it.
     * @param addressToScopeLevel A map from address to the scope level of the
     *                            variable.
     */
    public void visualize(Map<Integer, String> addressToVarName, Map<Integer, Integer> addressToScopeLevel) {
        System.out
                .println("+---------+----+------------+-------+--------+-----------------+--------------------------+");
        System.out
                .println("| Address | -> | Variable   | Scope | Marked | Type            | Value                    |");
        System.out
                .println("+---------+----+------------+-------+--------+-----------------+--------------------------+");

        if (memory.isEmpty()) {
            System.out.println(
                    "| (Heap is empty)                                                                          |");
        } else {
            memory.forEach((address, value) -> {
                String varName = addressToVarName.getOrDefault(address, "(no root)");
                Integer scope = addressToScopeLevel.get(address);
                String scopeStr = (scope != null) ? String.valueOf(scope) : "-";
                String type = value.getClass().getSimpleName();
                String valStr = value.toString();

                if (valStr.length() > 22) {
                    valStr = valStr.substring(0, 19) + "...";
                }

                System.out.printf("| %-7s | -> | %-10s | %-5s | %-6s | %-15s | %-24s |\n",
                        String.format("0x%X", address),
                        varName,
                        scopeStr,
                        value.marked,
                        type,
                        valStr);
            });
        }
        System.out
                .println("+---------+----+------------+-------+--------+-----------------+--------------------------+");
    }
}