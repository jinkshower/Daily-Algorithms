package interview;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class j2 {
        /*
        TASK
        주어진 문자열을 역순으로 출력한다.
     */

    @Test
    public void test() {
        assertThat(solution2("abc")).isEqualTo("cba");
    }

    private String solution2(String str) {
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[str.length() - i - 1] = str.charAt(i);
        }
        return new String(result);
    }
}
