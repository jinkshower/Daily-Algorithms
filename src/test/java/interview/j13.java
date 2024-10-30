package interview;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class j13 {
    public int calcDiceCase1(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return calcDiceCase1(n - 1) + calcDiceCase1(n - 2) +
                calcDiceCase1(n - 3) + calcDiceCase1(n - 4) +
                calcDiceCase1(n - 5) + calcDiceCase1(n - 6);
    }

    private int dp[] = new int[1000];

    public int calcDiceCase2(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        int result = 0;
        for (int i = 1; i <= 6; i++) {
            if (n - i >= 0) {
                if (dp[n - i] == 0) {
                    dp[n - i] = calcDiceCase2(n - i);
                }
                result += dp[n - i];
            }
        }
        return result;
    }

    @Test
    public void test() {
        assertThat(calcDiceCase1(3)).isEqualTo(4);
        assertThat(calcDiceCase1(4)).isEqualTo(8);
        assertThat(calcDiceCase1(5)).isEqualTo(16);
        assertThat(calcDiceCase1(6)).isEqualTo(32);
        assertThat(calcDiceCase1(7)).isEqualTo(63);
        assertThat(calcDiceCase1(8)).isEqualTo(125);

        assertThat(calcDiceCase2(4)).isEqualTo(8);
        assertThat(calcDiceCase2(5)).isEqualTo(16);
        assertThat(calcDiceCase2(6)).isEqualTo(32);
        assertThat(calcDiceCase2(7)).isEqualTo(63);
        assertThat(calcDiceCase2(8)).isEqualTo(125);
    }
}
