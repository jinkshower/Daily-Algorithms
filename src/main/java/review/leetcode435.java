package review;

import java.util.Arrays;

public class leetcode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
//        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int overlapped = 0;
        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] < end) {
                overlapped++;
            } else {
                end = interval[1];
                // System.out.println("end = " + end);
            }
        }
        return overlapped;
    }
}
