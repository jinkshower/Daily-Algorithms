package review;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class pro42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            int due = calDue(progresses[i], speeds[i]);
            deque.addLast(due);
        }
        // System.out.println(deque);
        int prev = deque.pollFirst();
        int count = 1;
        List<Integer> result = new ArrayList<>();
        while (!deque.isEmpty()) {
            int cur = deque.pollFirst();

            if (cur <= prev) {
                count++;
            } else {
                prev = cur;
                result.add(count);
                count = 1;
            }
        }

        result.add(count);

        return result.stream().mapToInt(i -> i).toArray();
    }

    private int calDue(int progress, int speed) {
        int count = 0;
        while (progress < 100) {
            progress += speed;
            count++;
        }
        return count;
    }
}
