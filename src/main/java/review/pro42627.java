package review;

import java.util.PriorityQueue;

public class pro42627 {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> request = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int[] job : jobs) {
            request.offer(job);
        }

        int size = jobs.length;
        int time = 0;

        PriorityQueue<int[]> waiting = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int past = 0;
        while (!request.isEmpty() || !waiting.isEmpty()) {

            while (!request.isEmpty() && request.peek()[0] <= past) {
                waiting.offer(request.poll());
            }
            if (!waiting.isEmpty()) {
                int[] cur = waiting.poll();
                time += past - cur[0] + cur[1];
                past += cur[1];
            } else {
                past++;
            }
        }

        return time / size;
    }
}
