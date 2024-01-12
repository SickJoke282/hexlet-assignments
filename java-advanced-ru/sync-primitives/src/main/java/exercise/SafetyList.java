package exercise;

import java.util.ArrayList;
import java.util.List;

class SafetyList {
    // BEGIN
    private final List<Integer> list = new ArrayList<>();
    public synchronized void add(int number) {
        list.add(number);
    }
    public List<Integer> get() {
        return list;
    }
    public int getSize() {
        return list.size();
    }
    // END
}
