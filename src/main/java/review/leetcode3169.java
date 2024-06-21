package review;

import java.util.Arrays;

public class leetcode3169 {

    public int countDays(int days, int[][] meetings) {
        //처음과 끝만 바꾸면서 빼는게 낫겠다.
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        // start와 end를 두고 앞의 end > 뒤의 start 이면 end를 바꾸면서 갱신
        //갱신이 끝나면 end - start를 총 count에 넣음.
        // 마지막에 count를 days에서 뺌

        int length = meetings.length;

        int start = meetings[0][0];
        int end = meetings[0][1];
        int count = 0;

        for (int i = 1; i < length; i++) {
            // end가 start보다 크거나 같으면 end를 갱신
            if (meetings[i][0] <= end) {
                end = Math.max(meetings[i][1], end);
                continue;
            }
            // end가 start보다 작으면 count에 end - start를 더하고 start와 end를 갱신
            count += end - start + 1;

            start = meetings[i][0];
            end = meetings[i][1];
        }
        // 마지막에 count에 end - start를 더함
        count += end - start + 1;

        return days - count;
    }
}
