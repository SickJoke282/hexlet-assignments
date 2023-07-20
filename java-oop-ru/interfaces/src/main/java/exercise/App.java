package exercise;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

// BEGIN
public class App {
    public static List<String> buildApartmentsList(List<Home> homes, int n) {
        List<String> answer = new LinkedList<>();
        homes.sort(Comparator.comparing(Home::getArea));
        if (n > homes.size()) {
            n = homes.size();
        }
        for (int i = 0; i < n; i++) {
            answer.add(homes.get(i).toString());
        }
        return answer;
    }
}
// END
