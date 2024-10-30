package interview;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;
import org.junit.jupiter.api.Test;

public class j19 {
        /*
        TASK
        Stack 자료구조를 사용하여 회문을 판별한다.
     */

    @Test
    public void test() {
        assertThat(isPalindrome("abba")).isTrue();
        assertThat(isPalindrome("dabccbad")).isTrue();
        assertThat(isPalindrome("abcba")).isTrue();
        assertThat(isPalindrome("fabccdedccbaf")).isTrue();
        assertThat(isPalindrome("fabccdedccbf")).isFalse();
    }

    public boolean isPalindrome(String str) {
        Stack<Character> stack = new Stack<>();
        char[] charArr = str.toCharArray();
        for (int i = 0; i < str.length() / 2; i++) {
            stack.add(charArr[i]);
        }

        for (int i = (str.length() + 1) / 2; i < str.length(); i++) {
            if (stack.pop() != charArr[i]) {
                return false;
            }
        }
        return true;
    }
}
