package interview;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class j4 {
    public boolean 애너그램판별_USE_MAP(String str1, String str2) {
        //arc car - > anagram !! how ?
        // 1. 정렬을한다 -> nlogn
        // 2. 각각 hash를 해서 key와 value가 같은지 판단한다 O(n)
        // -> 왼쪽 string을 hash로 ++ 하고 str2 는 돌면서 이 해쉬를 업앤다.
        // 마지막에 hash에 key가 남아 있으면 false
        Map<Character, Integer> hash = new HashMap<>();
        for (char c : str1.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            if (!hash.containsKey(c)) {
                return false;
            }
            int value = hash.get(c);
            if (value == 1) {
                hash.remove(c);
            } else {
                hash.put(c, value - 1);
            }
        }
        return hash.isEmpty();
    }

    @Test
    public void test() {
        assertThat(애너그램판별_USE_MAP("arc", "car")).isTrue();
        assertThat(애너그램판별_USE_MAP("caaabbb", "abababc")).isTrue();
        assertThat(애너그램판별_USE_MAP("caabbbb", "abababc")).isFalse();
        assertThat(애너그램판별_USE_MAP("arc", "carr")).isFalse();
        assertThat(애너그램판별_USE_MAP("arc", "caz")).isFalse();
    }
}
