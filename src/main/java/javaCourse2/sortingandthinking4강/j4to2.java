package javaCourse2.sortingandthinking4강;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class j4to2 {

    public int[] solution(int[] nums) {
        int[] answer = new int[nums.length / 2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        Arrays.sort(nums);

        int idx = 0;
        for (int x : nums) {
            if (map.get(x) == 0) {
                continue;
            }
            answer[idx] = x;
            idx++;
            map.put(x, map.get(x) - 1);
            map.put(x * 2, map.get(x * 2) - 1);
        }

        return answer;
    }
}
