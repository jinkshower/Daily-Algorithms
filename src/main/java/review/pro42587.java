package review;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class pro42587 {

    public int solution2(int[] priorities, int location) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> original = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
            original.offer(new int[]{priorities[i], i});
        }

        int count = 0;
        while (!original.isEmpty()) {
            int[] cur = original.poll();

            if (cur[0] == pq.peek()) {
                pq.poll();
                count++;

                if (cur[1] == location) {
                    return count;
                }
            } else {
                original.offer(cur);
            }
        }

        return answer;
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        int idx = 0;
        for (int prior : priorities) {
            q.offer(new int[]{prior, idx});
            idx++;
        }
        int count = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (containsHigher(q, cur[0])) {
                q.offer(cur);
            } else {
                count++;
                if (cur[1] == location) {
                    return count;
                }
            }
        }

        return answer;
    }

    private boolean containsHigher(Queue<int[]> q, int prior) {
        for (int[] e : q) {
            if (e[0] > prior) {
                return true;
            }
        }
        return false;
    }
}
