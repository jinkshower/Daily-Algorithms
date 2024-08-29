package review;

import java.util.HashMap;
import java.util.Map;

public class leetcode1679 {

    public int maxOperations(int[] nums, int k) {
        int result = 0;
        // boolean[] used = new boolean[nums.length];
        // for (int i = 0; i < nums.length; i++) { // O(n^2)
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (!used[i] && !used[j] && nums[i] + nums[j] == k) {
        //             used[i] = true;
        //             used[j] = true;
        //             result++;
        //         }
        //     }
        // }
        if (nums.length == 1) {
            return 0;
        }
        // Arrays.sort(nums); // O(Nlogn)
        // int lt = 0;
        // int rt = nums.length - 1;
        // while (lt < rt) { // O(n)
        //     int sum = nums[lt] + nums[rt];
        //     if (sum == k) {
        //         result++;
        //         lt++;
        //         rt--;
        //     } else if (sum > k) {
        //         rt--;
        //     } else if (sum < k) {
        //         lt++;
        //     }
        // }. // O(n + nlogn);

        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int aimKey = k - nums[i];
            if (hash.containsKey(aimKey)) {
                result++;
                if (hash.get(aimKey) == 1) {
                    hash.remove(aimKey);
                } else {
                    hash.put(aimKey, hash.get(aimKey) - 1);
                }
            } else {
                hash.put(nums[i], hash.getOrDefault(nums[i], 0) + 1);
            }
        }
        return result;

    }
}
