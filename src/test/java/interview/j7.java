package interview;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class j7 {


    public int gcdByIteration(int a, int b) {
        // 구현은 여기에 작성
        if (a < 0 || b < 0) {
            return -1;
        }
        int mod;
        while (b != 0) {
            mod = a % b;
            a = b;
            b = mod;
        }
        return a;
    }

    public int gcdByRecursion(int a, int b) {
        // 구현은 여기에 작성
        if (a < 0 || b < 0) {
            return -1;
        }
        if (b == 0) {
            return a;
        }
        return gcdByRecursion(b, a % b);
    }

    public int gcm(int a, int b) {
        return a * b / gcdByRecursion(a, b);
    }

    @Test
    public void test() {
        assertThat(gcdByIteration(-1, 0)).isEqualTo(-1);
        assertThat(gcdByIteration(0, 0)).isEqualTo(0);
        assertThat(gcdByIteration(6, 8)).isEqualTo(2);
        assertThat(gcdByIteration(3, 3)).isEqualTo(3);

        assertThat(gcdByRecursion(-1, 0)).isEqualTo(-1);
        assertThat(gcdByRecursion(0, 0)).isEqualTo(0);
        assertThat(gcdByRecursion(6, 8)).isEqualTo(2);
        assertThat(gcdByRecursion(3, 3)).isEqualTo(3);

        assertThat(gcm(6, 8)).isEqualTo(24);
    }
}
