/**
 * A simple record to hold the address and scope level of a variable.
 * This is used to pass detailed environment information to the visualizer.
 */
public record VariableInfo(int address, int scopeLevel) {
}