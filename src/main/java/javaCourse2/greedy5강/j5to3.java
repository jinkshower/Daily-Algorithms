package javaCourse2.greedy5강;

import java.util.Arrays;

public class j5to3 {

    public int solution(int n, int[] nums) {
        int answer = 0;
        int[][] line = new int[nums.length + 1][2];
        for (int i = 0; i <= n; i++) {
            int cur = nums[i];
            line[i][0] = Math.max(0, i - cur);
            line[i][1] = Math.min(n, i + cur);
        }

        Arrays.sort(line, (a, b) -> a[0] - b[0]);

        int start = 0;
        int end = 0;
        int i = 0;

        while (i < line.length) {

            while (i < line.length && line[i][0] <= start) {

                end = Math.max(end, line[i][1]);
                i++;
            }
            answer++;

            if (end == n) {
                return answer;
            }
            if (start == end) {
                return -1;
            }
            start = end;
        }

        return answer;
    }
}
