package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    String tagBody;
    List<Tag> tags;
    PairedTag(String tagName,
              Map<String, String> attributes,
              String tagBody,
              List<Tag> tags
    ) {
        super(tagName, attributes);
        this.tagBody = tagBody;
        this.tags = new ArrayList<>(tags);
    }
    @Override
    public String toString() {
        String result = "<" + this.tagName + " ";
        for (Map.Entry<String, String> attribute : attributes.entrySet()) {
            result = result.concat(attribute.getKey()
                    + "=\"" + attribute.getValue() + "\" ");
        }
        result = result.substring(0, result.length() - 1).concat(">").concat(tagBody);
        for (Tag tag : tags) {
            result = result.concat(tag.toString());
        }
        result = result.concat("</" + this.tagName + ">");
        return result;
    }
}
// END
