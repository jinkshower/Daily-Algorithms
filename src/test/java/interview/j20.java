package interview;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;
import org.junit.jupiter.api.Test;

public class j20 {
    @Test
    public void test() {
        assertThat(solution("(())")).isTrue();
        assertThat(solution("()()")).isTrue();
        assertThat(solution(")(())(")).isFalse();
        assertThat(solution("(())(")).isFalse();
        assertThat(solution(")(())")).isFalse();
        assertThat(solution("(()")).isFalse();
        assertThat(solution("())")).isFalse();

        assertThat(solution("(asdc;aga;ac;dsc;)")).isTrue();
        assertThat(solution("(aaa(bbb)ccc)")).isTrue();
    }

    public boolean solution(String braces) {
        Stack<Character> stack = new Stack<>();

        if (braces == null) {
            return true;
        }
        char open = '(';
        char close = ')';

        for (char c : braces.toCharArray()) {
            if (c == open) {
                stack.push(c);
            } else if (c == close) {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
