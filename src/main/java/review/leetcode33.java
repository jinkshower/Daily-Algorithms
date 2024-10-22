package review;

public class leetcode33 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            //찾았다면 가운데 인덱스 반환
            if (nums[m] == target) {
                return m;
            }

            if (nums[l] <= nums[m]) {
                if (nums[l] <= target && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else {
                if (nums[m] < target && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }
        return -1;
    }
}
