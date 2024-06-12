package javaCourse2.hasing2강;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class j2to3 {

    //못품- 강의풀이
    public int solution(String s) {
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (char key : map.keySet()) {
            while (set.contains(map.get(key))) {
                answer++;
                map.put(key, map.get(key) - 1);
            }
            if (map.get(key) == 0) {
                continue;
            }
            set.add(map.get(key));
        }
        return answer;
    }
}
