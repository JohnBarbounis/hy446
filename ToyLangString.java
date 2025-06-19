public class ToyLangString extends ToyLangValue {
    private final String value;

    public ToyLangString(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}