package exercise;

import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] array) {
        MaxThread maxThread = new MaxThread(array);
        MinThread minThread = new MinThread(array);
        maxThread.start();
        minThread.start();
        try {
            minThread.join();
        } catch (InterruptedException e) {
            System.out.println("huh");
        }
        return Map.of("min", minThread.getResult(), "max", maxThread.getResult());
    }
    // END
}
