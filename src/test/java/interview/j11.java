package interview;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class j11 {
    public int solution(int number) {
        // 각 자리 수의 합을 계산하는 구현
        int base = Math.abs(number);
        int result = 0;

        while (base > 0) {
            result += base % 10;
            base /= 10;
        }
        return result;
    }

    @Test
    public void test() {
        assertThat(solution(0)).isEqualTo(0);
        assertThat(solution(235)).isEqualTo(10);
        assertThat(solution(235678)).isEqualTo(31);
        assertThat(solution(-1)).isEqualTo(1); // 음수일 경우 절댓값의 각 자리 합으로 처리
    }
}
