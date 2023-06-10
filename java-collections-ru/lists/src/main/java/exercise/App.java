package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {
    public static boolean scrabble(String str, String word) {
        List<Character> answer = new ArrayList<>();
        List<Character> questionWord = new ArrayList<>();
        char[] chars = str.toCharArray();
        word = word.toLowerCase();
        char[] charWord = word.toCharArray();
        for (char chr: charWord) {
            questionWord.add(chr);
        }
        List<Character> temp = new ArrayList<>(questionWord);
        for (char chr: chars) {
            if (temp.contains(chr)) {
                answer.add(chr);
                System.out.println(answer);
                temp.remove(temp.indexOf(chr));
            }
        }
        return answer.containsAll(questionWord) && answer.size() == questionWord.size();
    }
}
//END
