package exercise;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {
    public static Map<String, Integer> getWordCount(String question) {
        if (question.equals("")) {
            return new HashMap<>();
        }
        String[] strArr = question.split(" ");
        Map<String, Integer> answer = new HashMap<>();
        for (String str: strArr) {
            if (answer.containsKey(str)) {
                int temp = answer.get(str);
                temp++;
                answer.replace(str, temp);
            }
            answer.putIfAbsent(str, 1);
        }
        return answer;
    }
    public static String toString(Map<String, Integer> map) {
        String answer = "{\n";
        if (map.isEmpty()) {
            return "{}";
        }
        for (String entry: map.keySet()) {
            answer += "  " + entry + ": " + map.get(entry).toString() + "\n";
        }
        answer += "}";
        return answer;
    }
}
//END
