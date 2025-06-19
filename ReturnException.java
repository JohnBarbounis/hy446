public class ReturnException extends RuntimeException {
    public final Integer returnValueAddress;

    public ReturnException(Integer returnValueAddress) {
        // Disable stack trace generation for performance, as this is for control flow.
        super(null, null, false, false);
        this.returnValueAddress = returnValueAddress;
    }
}