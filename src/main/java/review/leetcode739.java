package review;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<int[]> stack = new ArrayDeque<>();

        // Monotonic stack. 스택을 decreasing (이 문제는 같은 숫자 포함)하게 유지
        // index를 같이 넣어서 top 보다 큰 값이 오면! result를 채울수 있는 명분이 된다.
        // 더 큰 값이 들어가지 않게 pop을 하고 pop한번 할 때마다 index의 차이를 result에 기록
        // stack은 decreasing하게 유지된다

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                int[] top = stack.pop();
                result[top[0]] = i - top[0];
            }
            stack.push(new int[]{i, temperatures[i]});
        }
        return result;
    }
}
