package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class PairedTag extends Tag {

    private String body;
    private List<Tag> children = new ArrayList<>();

    public PairedTag(String name, Map<String, String> attributes, String body, List<Tag> children) {
        super(name, attributes);
        this.body = body;
        this.children.addAll(children);
    }


    @Override
    public String toString() {

        String closeName = "</" + this.name + ">";
        StringBuilder childrenToString = new StringBuilder();
        for (var c : children) {
            childrenToString.append(c.toString());
        }

        return String.format("%s%s%s%s", super.toString(), body, childrenToString, closeName);
    }


}
// END
