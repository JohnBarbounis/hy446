import java.util.List;

public class ToyLangFunction extends ToyLangValue {
    private final List<String> parameters;
    private final ToyLangParser.ProgramContext body;

    public ToyLangFunction(List<String> parameters, ToyLangParser.ProgramContext body) {
        this.parameters = parameters;
        this.body = body;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public ToyLangParser.ProgramContext getBody() {
        return body;
    }

    @Override
    public Object getValue() {
        return this;
    }

    @Override
    public String toString() {
        return "<function(" + String.join(", ", parameters) + ")>";
    }
}