import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.Map;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        long totalStartTime = System.nanoTime(); // Start timer for the whole program

        CharStream input = CharStreams.fromFileName(args[0]);
        ToyLangLexer lexer = new ToyLangLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ToyLangParser parser = new ToyLangParser(tokens);
        ParseTree tree = parser.program();

        ToyLangInterpreter interpreter = new ToyLangInterpreter();
        interpreter.visit(tree);

        // Perform one final GC at the end of the script to clean everything up.
        System.out.println("\n--- Script finished, performing final cleanup GC ---");
        interpreter.runGC();

        // Print the final state for verification
        System.out.println("\nExecution finished. Final environment state:");
        interpreter.printFinalEnvironmentState();

        long totalEndTime = System.nanoTime(); // End timer for the whole program
        long totalExecutionTimeNs = totalEndTime - totalStartTime;

        // --- NEW BENCHMARK SUMMARY ---
        System.out.println("\n--- Benchmark Summary ---");
        long totalGCTime = interpreter.getTotalGCPauseTimeNs();
        double totalGCTimeMs = totalGCTime / 1_000_000.0;
        List<Long> pauses = interpreter.getGcPauseDurations();

        System.out.printf("Total time spent in Garbage Collection: %,d ns (%.2f ms)\n", totalGCTime, totalGCTimeMs);
        if (!pauses.isEmpty()) {
            double averagePauseMs = pauses.stream().mapToLong(Long::longValue).average().orElse(0) / 1_000_000.0;
            long maxPauseNs = pauses.stream().mapToLong(Long::longValue).max().orElse(0);
            long minPauseNs = pauses.stream().mapToLong(Long::longValue).min().orElse(0);
            System.out.printf("GC Runs: %d\n", pauses.size());
            System.out.printf("Average Pause: %.2f ms\n", averagePauseMs);
            System.out.printf("Max Pause: %.2f ms\n", maxPauseNs / 1_000_000.0);
            System.out.printf("Min Pause: %.2f ms\n", minPauseNs / 1_000_000.0);
        }

        double throughput = ((double) (totalExecutionTimeNs - totalGCTime) / totalExecutionTimeNs) * 100;
        System.out.printf("Application Throughput: %.2f%%\n", throughput);
    }
}