package exercise;

// BEGIN
public class ReversedSequence implements CharSequence {
    String str;
    ReversedSequence(String str) {
        this.str = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            this.str += str.toCharArray()[i];
        }
    }
    @Override
    public String toString() {
        return str;
    }
    public char charAt(int index) {
        return str.toCharArray()[index];
    }
    public int length() {
        int length = 0;
        for (char c: str.toCharArray()) {
            length++;
        }
        return length;
    }
    public String subSequence(int firstIndex, int lastIndex) {
        String result = "";
        for (int i = firstIndex; i < lastIndex; i++) {
            result += str.toCharArray()[i];
        }
        return result;
    }
}
// END
