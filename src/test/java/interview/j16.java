package interview;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class j16 {
    public List<String> 괄호경우의수구하기(int n) {
        if (n == 0) {
            return null;
        }
        return combination(n, n, "", new ArrayList<>());
    }

    private List<String> combination(int start, int end, String pairs, List<String> result) {
        if (start > end) {
            return result;
        }
        if (start < 0 || end < 0) {
            return result;
        }
        if (start == 0 && end == 0) {
            result.add(pairs);
            return result;
        }
        combination(start - 1, end, pairs + "(", result);
        combination(start, end - 1, pairs + ")", result);
        return result;
    }

    @Test
    public void test() {
        assertThat(괄호경우의수구하기(0)).isNull();

        List<String> actual = new ArrayList<>();
        actual.add("(())");
        actual.add("()()");
        assertThat(괄호경우의수구하기(2)).isEqualTo(actual);
    }
}
