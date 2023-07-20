package exercise;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ReversedSequenceTest {
    ReversedSequence str = new ReversedSequence("abcdef");
    @Test
    void testToString() {
        assertThat(str.toString()).isEqualTo("fedcba");
    }
    @Test
    void testCharAt() {
        assertThat(str.charAt(1)).isEqualTo('e');
    }
    @Test
    void testLength() {
        assertThat(str.length()).isEqualTo(6);
    }
    @Test
    void testSubSequence() {
        assertThat(str.subSequence(1, 4)).isEqualTo("edc");
    }
}
