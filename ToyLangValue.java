public abstract class ToyLangValue {
    public boolean marked = false;
    public int age = 0;

    // Helper to get the underlying Java object for operations/printing
    public abstract Object getValue();

    /**
     * Determines if this value is "truthy" in a boolean context.
     * By default, most objects are considered true.
     */
    public boolean isTruthy() {
        return true;
    }
}
