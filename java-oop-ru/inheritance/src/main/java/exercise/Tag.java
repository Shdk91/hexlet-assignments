package exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {

protected String name;
protected Map<String, String> attributes = new LinkedHashMap<>();

    public Tag(String name, Map<String, String> attributes) {
        this.name = name;
        this.attributes.putAll(attributes);
    }


    @Override
    public String toString() {
        StringBuilder map = new StringBuilder();
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            map.append(" " + entry.getKey() + "=\"" + entry.getValue() + "\"");
        }
        return String.format("<%s%s>", name, map.toString());
    }


}


// END
