public class ToyLangBoolean extends ToyLangValue {
    private final boolean value;

    public ToyLangBoolean(boolean value) {
        this.value = value;
    }

    @Override
    public Boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public boolean isTruthy() {
        return this.value;
    }
}