package exercise;

// BEGIN
public class MinThread extends Thread {
    private int[] array;
    public MinThread(int[] array) {
        this.array = array;
    }
    int result;
    @Override
    public void run() {
        int temp = array[0];
        for (int num : array) {
            if (temp > num) {
                temp = num;
            }
            System.out.println(temp);
        }
        result = temp;
    }
    public int getResult() {
        return this.result;
    }
}
// END
