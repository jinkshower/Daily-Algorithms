package javaCourse2.hasing2강;

import java.util.HashMap;
import java.util.Map;

public class j2to1 {

    //내풀이
    public int solution(String s) {
        int answer = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int origin = s.indexOf(c);
            int last = s.lastIndexOf(c);
            if (origin == last) {
                answer = origin + 1;
                break;
            }
        }
        return answer;
    }

    //강의풀이
    public int solution2(String s) {
        int answer = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                answer = i + 1;
                break;
            }
        }
        return answer;
    }
}
