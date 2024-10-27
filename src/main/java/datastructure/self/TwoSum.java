package datastructure.self;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] findTwoSum(int[] arr, int target) {//n logN
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length - 1;

        while (l < r) {
            int sum = arr[l] + arr[r];

            if (sum == target) {
                return new int[]{l, r};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return null;
    }

    public int[] findTwoSum2(int[] arr, int target) {//O(n) but can't handle duplicate
        Map<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int aim = target - arr[i];
            if (hash.containsKey(aim)) {
                return new int[]{hash.get(aim), i};
            }
            hash.put(arr[i], i);
        }
    }
}
