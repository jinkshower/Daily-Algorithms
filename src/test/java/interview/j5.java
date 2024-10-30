package interview;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class j5 {
    public String runLengthCompress_USE_HASHMAP(String input) {
        if (input == null) {
            return null;
        }
        // a 3 b 3 c 3 이렇게 된다? hash가 바로 떠오르는걸~
        // 그런데 이게 abc이렇게 들어오는 순서대로 유지를 해야한다
        Map<Character, Integer> hash = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        hash.forEach((k, v) -> sb.append(k).append(v.toString()));
        return sb.toString();
    }

    @Test
    public void test() {
        assertThat(runLengthCompress_USE_HASHMAP(null)).isNull();
        assertThat(runLengthCompress_USE_HASHMAP("aaabbbccc")).isEqualTo("a3b3c3");
        assertThat(runLengthCompress_USE_HASHMAP("aabbacbccc")).isEqualTo("a3b3c4");
        assertThat(runLengthCompress_USE_HASHMAP("cccbbbaaaa")).isEqualTo("c3b3a4");
    }
}
