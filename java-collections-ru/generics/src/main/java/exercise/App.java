package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

// BEGIN
public class App {
    public static List<Map<String, String>> findWhere(List<Map<String, String>> books, Map<String, String> where) {
        List<Map<String, String>> result = new ArrayList<>();
        int length = where.size();
        for (Map<String, String> book: books) {
            int counter = 0;
            for (Map.Entry<String, String> entryWhere: where.entrySet()) {
                if (book.containsValue(entryWhere.getValue())) {
                    counter++;
                }
            }
            if (length == counter) {
                result.add(book);
            }
        }
        System.out.println(result);
        return result;
    }
}
//END
