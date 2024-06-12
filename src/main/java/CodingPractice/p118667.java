package CodingPractice;

import java.util.LinkedList;
import java.util.Queue;

public class p118667 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }
        int cnt = 0;
        int n = 0;
        if (sum1 == sum2) return 0;
        while (sum1 != sum2 && n < queue1.length * 4) {
            if (sum1 < sum2) {
                int tmp = q2.poll();
                sum2 -= tmp;
                sum1 += tmp;
                q1.offer(tmp);
                cnt++;
            } else if (sum1 > sum2) {
                int tmp = q1.poll();
                sum1 -= tmp;
                sum2 += tmp;
                q2.offer(tmp);
                cnt++;
            }
            if ((sum1 + sum2) % 2 != 0) break;
            if (q1.isEmpty() || q2.isEmpty()) break;
            n++;
        }

        return sum1 == sum2 ? cnt : -1;
    }
}
