package exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    protected String tagName;
    protected Map<String, String> attributes;
    Tag(String tagName, Map<String, String> attributes) {
        this.tagName = tagName;
        this.attributes = new LinkedHashMap<>(attributes);
    }
    public String toString() {
        String result = "<" + this.tagName + " ";
        for (Map.Entry<String, String> attribute : attributes.entrySet()) {
            result = result.concat(attribute.getKey()
                    + "=\"" + attribute.getValue() + "\" ");
        }
        result = result.substring(0, result.length() - 1).concat(">");
        return result;
    }
}
// END
