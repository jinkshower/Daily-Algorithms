package javaCourse2.bfs7강;

import java.util.LinkedList;
import java.util.Queue;

public class j7to1 {

    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        int[] ch = new int[n];

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(0);
        ch[0] = 1;
        int L = 0;

        while (!Q.isEmpty()) {
            int len = Q.size();//현재 레벨의 개수 만큼
            for (int i = 0; i < len; i++) {
                int x = Q.poll();
                for (int j = 1; j <= nums[x]; j++) {
                    int nx = x + j;
                    if (nx == n - 1) {
                        return L + 1;
                    }
                    if (nx < n && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }

        return -1;
    }
}
