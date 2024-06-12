package CodingPractice;

import java.util.HashMap;
import java.util.Map;

public class p42578 {

    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String cur = clothes[i][1];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        if (map.size() == 1) {
            return map.get(clothes[0][1]);
        }
        int answer = 1;
        for (int x : map.values()) {
            answer *= x + 1;
        }

        return answer - 1;
    }
}
