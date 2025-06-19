public class ToyLangNull extends ToyLangValue {
    @Override
    public Object getValue() {
        return null;
    }

    @Override
    public String toString() {
        return "null";
    }

    @Override
    public boolean isTruthy() {
        return false;
    }
}