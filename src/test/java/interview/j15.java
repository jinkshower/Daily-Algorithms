package interview;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class j15 {
    public List<String> calcPermutation(String str) {
        // 문자열의 순열을 계산하는 구현
        List<String> list = new ArrayList<>();
        boolean[] visited = new boolean[str.length()];
        return re(str, visited, "", list);
    }

    private List<String> re(String str, boolean[] visited, String perm, List<String> list) {
        if (str.length() == perm.length()) {
            list.add(perm);
            return list;
        }

        for (int i = 0; i < str.length(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            re(str, visited, perm + str.charAt(i), list);
            visited[i] = false;
        }
        return list;
    }

    @Test
    public void test() {
        List<String> actual = new ArrayList<>();
        actual.add("123");
        actual.add("132");
        actual.add("213");
        actual.add("231");
        actual.add("312");
        actual.add("321");
        assertThat(calcPermutation("123")).isEqualTo(actual);
    }
}
