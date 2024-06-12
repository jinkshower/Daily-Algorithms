package CodingPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p133499 {
    public int solution(String[] babbling) {
        int answer = 0;
        Map<String, Integer> zoka = new HashMap<>(
                Map.of("aya", 1,
                        "ye", 2,
                        "woo", 3,
                        "ma", 4)
        );
        List<String> translated = new ArrayList<>();
        for (String string : babbling) {
            for (String word : zoka.keySet()) {
                string = string.replace(word, zoka.get(word).toString());
            }
            translated.add(string);
        }

        for (String result : translated) {
            if (result.matches(".*[a-zA-Z].*")) {
                continue;
            }
            char[] chars = result.toCharArray();
            boolean flag = true;
            for (int i = 0; i < chars.length - 1; i++) {
                if (chars[i] == chars[i + 1]) {
                    flag = false;
                }
            }
            if (flag) answer++;
        }
        return answer;
    }
}
