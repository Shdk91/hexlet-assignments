package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {

    private Map<String, String> data = new HashMap<>();


    public InMemoryKV(Map<String, String> map) {
        data.putAll(map);
    }

    @Override
    public void set(String key, String value) {
        data.put(key, value);

    }

    @Override
    public void unset(String key) {
        data.remove(key);
    }

    @Override
    public String get(String key, String defaultValue) {
        return data.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(data);
    }

    public static void main(String[] args) {
        KeyValueStorage storage = new InMemoryKV(Map.of("key", "10"));
        // Получение значения по ключу
        storage.get("key", "default"); // "10"
        storage.get("unknown", "default"); // "default"
        // Установка нового значения
        storage.set("key2", "value2");
        storage.get("key2", "default"); // "value2"
        // Удаление ключа
        storage.unset("key2");
        storage.get("key2", "default"); // "default"
        // Получение всех данных из базы
        Map<String, String> data = storage.toMap();
        System.out.println(data); // => {key=10};
    }
}
// END
