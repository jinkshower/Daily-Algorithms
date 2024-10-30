package interview;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class j8 {
    public int getByRecursion(int n, int r) {
        if (r == 0 || n == r) {
            return 1;
        }
        return getByRecursion(n - 1, r - 1) + getByRecursion(n - 1, r);
    }

    public int getByDp(int n, int r) {
        int[][] cache = new int[10][10];
        if (r == 0 || n == r) {
            return 1;
        }
        if (cache[n][r] != 0) {
            return cache[n][r];
        }
        return cache[n][r] = getByDp(n - 1, r - 1) + getByDp(n - 1, r);
    }

    @Test
    public void test() {
        assertThat(getByRecursion(0, 0)).isEqualTo(1);
        assertThat(getByRecursion(1, 0)).isEqualTo(1);
        assertThat(getByRecursion(2, 1)).isEqualTo(2);
        assertThat(getByRecursion(8, 3)).isEqualTo(56);

        assertThat(getByDp(0, 0)).isEqualTo(1);
        assertThat(getByDp(1, 0)).isEqualTo(1);
        assertThat(getByDp(2, 1)).isEqualTo(2);
        assertThat(getByDp(8, 3)).isEqualTo(56);
    }
}
