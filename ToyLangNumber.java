public class ToyLangNumber extends ToyLangValue {
    private final Integer value;

    public ToyLangNumber(Integer value) {
        this.value = value;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean isTruthy() {
        // In JS, 0 is falsy, all other numbers are truthy.
        return this.value != 0;
    }
}