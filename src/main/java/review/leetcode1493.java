package review;

public class leetcode1493 {

    public int longestSubarray(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int lt = 0;
        int rt = 0;
        int zeros = 0;
        int max = -1;

        while (rt < nums.length) {
            if (nums[rt] == 0) {
                zeros++;
            }
            while (zeros > 1) {
                if (nums[lt] == 0) {
                    zeros--;
                }
                lt++;
            }
            max = Math.max(max, rt - lt);
            rt++;
        }
        return max;
    }
}
