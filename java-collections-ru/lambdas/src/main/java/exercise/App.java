package exercise;

import java.util.Arrays;

// BEGIN
public class App {
    public static String[][] enlargeArrayImage(String[][] image) {
        String[][] enlargedImg = new String[image.length * 2][image.length * 2];
        for (int i = 0; i < enlargedImg.length; i++) {
            for (int j = 0; j < enlargedImg.length; j++){
                if (j == 0 || j == 1 || j == enlargedImg.length - 2 || j == enlargedImg.length - 1 || i == 0 || i == 1 || i == enlargedImg.length - 1 || i == enlargedImg.length - 2) {
                    enlargedImg[i][j] = "*";
                } else {
                    enlargedImg[i][j] = " ";
                }
            }
        }
        return enlargedImg;
    }
}
// END
