package interview;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class j9 {

    public int solution(int n) {
        if (n < 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }

        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true; //처음엔 모두 소수로 간주
        }

        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void test() {
        assertThat(solution(-3)).isEqualTo(-1); // 음수 입력에 대한 처리
        assertThat(solution(0)).isEqualTo(0);
        assertThat(solution(1)).isEqualTo(0);
        assertThat(solution(2)).isEqualTo(1); // 2 하나만 포함
        assertThat(solution(3)).isEqualTo(2); // 2, 3 포함
        assertThat(solution(8)).isEqualTo(4); // 2, 3, 5, 7 포함
        assertThat(solution(12)).isEqualTo(5); // 2, 3, 5, 7, 11 포함
        assertThat(solution(44)).isEqualTo(14); // 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43 포함
    }
}
