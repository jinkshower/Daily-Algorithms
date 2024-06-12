package javaCourse2.greedy5강;

import java.util.Arrays;

public class j5to1 {

    public int solution(int[] nums, int m) {
        int answer = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] + nums[right] <= m) {
                answer++;
                left++;
                right--;
            } else {
                answer++;
                right--;
            }
        }
        return answer;
    }
}
