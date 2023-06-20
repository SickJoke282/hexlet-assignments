package exercise;

import java.util.*;
import java.util.stream.Collectors;

// BEGIN
class App {
    public static String getForwardedVariables(String content) {
        String[] arr = content.split("\n");
        List<String> ans = Arrays.stream(arr)
                .filter(x -> x.startsWith("environment="))
                .filter((x -> x.contains("X_FORWARDED_")))
                .map(x -> x.replace("environment=", "")).toList();
        String temp = ans.toString()
                .replace("[\"", "")
                .replace("\"]", "");
        arr = temp.split("=");
        Map<String, String> m = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains("X_FORWARDED_")) {
                arr[i+1] = arr[i+1].replace("\"", "");
                m.put(arr[i].substring(arr[i].lastIndexOf("_") + 1), arr[i+1].substring(0, arr[i+1].indexOf(",")));
            }
        }
        return m.toString().replace(" ", "").replace("{", "").replace("}", "");
    }
}
//END
