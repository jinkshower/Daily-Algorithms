package CodingPractice;

import java.util.HashMap;
import java.util.Map;

public class p131127 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        Map<String, Integer> disMap = new HashMap<>();
        int cnt = 0;

        for (int i = 0; i < 10; i++) {
            disMap.put(discount[i], disMap.getOrDefault(discount[i], 0) + 1);
        }

        if (map.equals(disMap)) {
            cnt++;
        }

        int lt = 0;
        for (int rt = 10; rt < discount.length; rt++) {
            String cur = discount[rt];
            String prev = discount[lt];

            disMap.put(cur, disMap.getOrDefault(cur, 0) + 1);

            if (disMap.get(prev) == 1) {
                disMap.remove(prev);
            } else {
                disMap.put(prev, disMap.get(prev) - 1);
            }

            if (map.equals(disMap)) {
                cnt++;
            }
            lt++;
        }
        return cnt;
    }
}
