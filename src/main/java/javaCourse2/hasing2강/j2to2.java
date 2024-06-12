package javaCourse2.hasing2강;

import java.util.HashMap;
import java.util.Map;

public class j2to2 {

    //내 풀이
    public int[] solution(String s) {
        int[] answer = new int[5];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put((char) ('a' + i), 0);
        }
        int max = -1;
        for (char c : s.toCharArray()) {
            int cur = map.get(c) + 1;
            max = Math.max(max, cur);
            map.put(c, cur);
        }
        for (int i = 0; i < 5; i++) {
            int tmp = map.get((char) ('a' + i));
            answer[i] = max - tmp;
        }
        return answer;
    }
}
