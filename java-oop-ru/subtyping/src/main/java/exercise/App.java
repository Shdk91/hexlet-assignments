package exercise;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {

    public static void swapKeyValue(KeyValueStorage kvm) {
        Map<String,String> map = new HashMap<>(kvm.toMap());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getValue();
            String value = entry.getKey();
            kvm.unset(entry.getKey());
            kvm.set(key, value);

        }


    }

    public static void main(String[] args) {
        KeyValueStorage storage = new InMemoryKV(Map.of("key", "value", "key2", "value2"));
        App.swapKeyValue(storage);
        storage.get("key", "default"); // "default"
        storage.get("value", "default"); // "key"

        System.out.println(storage.toMap());
    }
}
// END
