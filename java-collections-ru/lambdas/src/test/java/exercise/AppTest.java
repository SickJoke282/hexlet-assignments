package exercise;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {
    @Test
    void testApp() {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };
        String[][] enlargedImage = App.enlargeArrayImage(image);
        assertThat(Arrays.deepToString(enlargedImage)).isEqualTo("[" +
                "[*, *, *, *, *, *, *, *], " +
                "[*, *, *, *, *, *, *, *], " +
                "[*, *,  ,  ,  ,  , *, *], " +
                "[*, *,  ,  ,  ,  , *, *], " +
                "[*, *,  ,  ,  ,  , *, *], " +
                "[*, *,  ,  ,  ,  , *, *], " +
                "[*, *, *, *, *, *, *, *], " +
                "[*, *, *, *, *, *, *, *]"   +
                "]");
    }
}
// END
