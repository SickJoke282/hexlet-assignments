package exercise;

import java.util.*;

// BEGIN
class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {
        Map<String, String> ans = new HashMap<>();
        Set<Map.Entry<String, Object>> entrySet = data1.entrySet();
        Set<Map.Entry<String, Object>> entrySet2 = data2.entrySet();
        entrySet.stream()
                .forEach(x -> {
                    if (data2.containsKey(x.getKey())) {
                        if (data2.containsValue(x.getValue())) {
                            ans.put(x.getKey(), "unchanged");
                        } else {
                            ans.put(x.getKey(), "changed");
                        }
                    } else {
                        ans.put(x.getKey(), "deleted");
                    }
                });
        entrySet2.stream()
                .forEach(x -> {
                    if(!data1.containsKey(x.getKey())) {
                        ans.put(x.getKey(), "added");
                    }
                });
        return ans;
    }
}
//END
