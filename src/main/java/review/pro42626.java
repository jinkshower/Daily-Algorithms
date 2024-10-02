package review;

import java.util.PriorityQueue;

public class pro42626 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int sc : scoville) {
            pq.offer(sc);
        }

        int mixCount = 0;
        while (pq.size() != 1) {
            if (pq.peek() >= K) {
                return mixCount;
            }

            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a + b * 2);
            mixCount++;
        }
        //한개 남았을 경우 체크
        if (pq.peek() >= K) {
            return mixCount;
        }

        return -1;
    }
}
