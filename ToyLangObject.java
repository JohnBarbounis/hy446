import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ToyLangObject extends ToyLangValue {
    // Maps property names to the heap address of their values
    private final Map<String, Integer> properties = new LinkedHashMap<>();

    public void setProperty(String key, Integer address) {
        properties.put(key, address);
    }

    public Map<String, Integer> getProperties() {
        return properties;
    }

    @Override
    public Object getValue() {
        return this; // The object itself is the value
    }

    @Override
    public String toString() {
        // Provides a nice string representation like { "key": address, ... }
        String props = properties.entrySet().stream()
                .map(e -> "\"" + e.getKey() + "\": " + String.format("0x%X", e.getValue()))
                .collect(Collectors.joining(", "));
        return "{ " + props + " }";
    }
}