package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    String filePath;
    Map<String, String> storage;
    FileKV(String filePath, Map<String, String> storage) {
        this.filePath  = filePath;
        this.storage = new HashMap<>(storage);
    }

    @Override
    public void set(String key, String value) {
        storage.put(key, value);
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    @Override
    public void unset(String key) {
        storage.remove(key);
        Utils.writeFile(filePath, Utils.serialize(storage));
    }

    @Override
    public String get(String key, String defaultValue) {
        return storage.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return new HashMap<>(storage);
    }
}
// END
