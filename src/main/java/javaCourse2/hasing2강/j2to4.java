package javaCourse2.hasing2강;

import java.util.HashMap;
import java.util.Map;

public class j2to4 {

    //강의 풀이
    public int solution(int[] nums, int m) {
        int answer = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - m)) {
                answer += map.get(sum - m);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }
}
