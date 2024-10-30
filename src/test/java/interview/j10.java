package interview;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class j10 {
    @Test
    public void test() {
        assertThat(calcFiboByRec(5)).isEqualTo(5);
        assertThat(calcFiboByRec(6)).isEqualTo(8);
        assertThat(calcFiboByRec(7)).isEqualTo(13);

        assertThat(fiboByDp(5)).isEqualTo(5);
        assertThat(fiboByDp(6)).isEqualTo(8);
        assertThat(fiboByDp(7)).isEqualTo(13);
    }

    public int calcFiboByRec(int n) {
        // 재귀를 이용한 구현
        if (n < 0) {
            return -1;
        }
        if (n < 2) {
            return n;
        }
        return calcFiboByRec(n - 1) + calcFiboByRec(n - 2);
    }

    public int fiboByDp(int n) {
        return calcFibo(n, new int[n + 1]);
    }

    private int calcFibo(int n, int[] cache) {
        if (n < 2) {
            return n;
        }
        if (cache[n] != 0) {
            return cache[n];
        }
        return cache[n] = calcFibo(n - 1, cache) + calcFibo(n - 2, cache);
    }
}
