package exercise;

// BEGIN
public class MaxThread extends Thread {
    private int[] array;
    public MaxThread(int[] array) {
        this.array = array;
    }
    int result;
    @Override
    public void run() {
        int temp = array[0];
        for (int num : array) {
            if (temp < num) {
                temp = num;
            }
        }
        result = temp;
    }
    public int getResult() {
        return this.result;
    }
}
// END
