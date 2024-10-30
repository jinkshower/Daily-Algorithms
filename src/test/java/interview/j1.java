package interview;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class j1 {
    /*
    TASK
    주어진 문자열을 int 형으로 변환한다.
    */

    @Test
    public void toIntFromString() {
        assertThat(toIntFromString("123")).isEqualTo(123);
    }

    private int toIntFromString(String str) {
        char[] chars = str.toCharArray();
        int base = 0;
        for (char c : chars) {
            base *= 10;
            base += c - '0';
        }
        return base;
    }

}
