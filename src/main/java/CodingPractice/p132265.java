package CodingPractice;

import java.util.HashMap;
import java.util.Map;

public class p132265 {

    public int solution(int[] topping) {
        int answer = -1;
        int len = topping.length;

        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int i = 0; i < len; i++) {
            right.put(topping[i], right.getOrDefault(topping[i], 0) + 1);
        }
        int cnt = 0;
        int rt = 0;
        for (int lt = 0; lt < len - 1; lt++) {
            //lt의 요소 넣음
            int leftC = left.getOrDefault(topping[lt], 0);
            left.put(topping[lt], leftC + 1);

            // rt의 요소 뺌
            int rightC = right.get(topping[rt]);
            if (rightC > 1) {
                right.put(topping[rt], rightC - 1);
            } else {
                right.remove(topping[rt]);
            }

            if (left.keySet().size() == right.keySet().size()) {
                cnt++;
            }
            rt++;
        }

        return cnt;
    }
}
