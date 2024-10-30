package interview;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class j3 {

        /*
        TASK
        주어진 문자열에서 문자열을 구성하고 있는 각각의 문자열들이 고유한지를 판단한다.
     */

    @Test
    public void test() {
        assertThat(HashSet을_사용한_방법("abcd")).isTrue();
        assertThat(HashSet을_사용한_방법("abcdefghij")).isTrue();
        assertThat(HashSet을_사용한_방법("abccde")).isFalse();
        assertThat(HashSet을_사용한_방법("abca")).isFalse();
    }

    private boolean HashSet을_사용한_방법(String str) {
        Set<Character> set = new HashSet<>();

        for (char c : str.toCharArray()) {
            set.add(c);
        }
        return str.length() == set.size();
    }

}
