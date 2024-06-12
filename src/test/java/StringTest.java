import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
    @Test
    void stringSplit() {
        String beforeSplit = "1,2";
        String[] actual = beforeSplit.split(",");
        assertThat(actual).contains("1", "2");
    }

    @Test
    void stringSplit2() {
        String beforeSplit = "1";
        String[] actual = beforeSplit.split(",");
        assertThat(actual).containsOnly("1");
    }

    @Test
    void substring1() {
        String beforeRemoval = "(1,2)";
        String actual = beforeRemoval.substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("범위를 벗어난 경우 예외 처리")
    void exceptionString() {
        String beforeIndexing = "abc";
//        assertThatThrownBy(() -> beforeIndexing.charAt(4))
//                .isInstanceOf(IndexOutOfBoundsException.class)
//                .hasMessageContaining("String index out of range: 4");
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> beforeIndexing.charAt(4))
                .withMessageMatching("String index out of range: 4");
    }
}
