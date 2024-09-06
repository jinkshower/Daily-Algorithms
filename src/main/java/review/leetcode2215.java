package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode2215 {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        //brute force
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list1 = Arrays.stream(nums1).boxed().toList();
        List<Integer> list2 = Arrays.stream(nums2).boxed().toList();

        Set<Integer> distinct1 = new HashSet<>();
        Set<Integer> distinct2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            if (!list2.contains(nums1[i])) {
                distinct1.add(nums1[i]);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (!list1.contains(nums2[i])) {
                distinct2.add(nums2[i]);
            }
        }
        result.add(new ArrayList<>(distinct1));
        result.add(new ArrayList<>(distinct2));
        return result;

    }

    public List<List<Integer>> findDifference2(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }

        for (int i : nums2) {
            set2.add(i);
        }

        Set<Integer> tmp1 = new HashSet<>(set1);
        Set<Integer> tmp2 = new HashSet<>(set2);
        for (int i : set1) {
            if (set2.contains(i)) {
                tmp1.remove(i);
                tmp2.remove(i);
            }
        }
        // System.out.println(tmp1);
        // System.out.println(tmp2);
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(tmp1));
        result.add(new ArrayList<>(tmp2));
        return result;
    }
}
