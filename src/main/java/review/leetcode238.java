package review;

public class leetcode238 {

    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length + 2];
        int[] suffix = new int[nums.length + 2];
        prefix[0] = 1;
        prefix[nums.length + 1] = 1;
        suffix[0] = 1;
        suffix[nums.length + 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] * nums[i];
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            suffix[i + 1] = suffix[i + 2] * nums[i];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * suffix[i + 2];
        }
        return result;
    }
}
