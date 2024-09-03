package review;

public class leetcode1004 {
    public int longestOnes(int[] nums, int k) {
        int lt = 0;
        int rt = 0;
        int max = -1;
        int zeros = 0;
        while (rt < nums.length) {
            if (nums[rt] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[lt] == 0) {
                    zeros--;
                }
                lt++;
            }
            max = Math.max(max, rt - lt + 1);
            rt++;
        }
        return max;
    }
}
