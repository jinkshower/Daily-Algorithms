package review;

public class leetcode11 {
    public int maxArea(int[] height) {
        //O(n^2)
        // int max = -1;
        // for (int i = 0; i < height.length; i++) {
        //     for (int j = i + 1; j < height.length; j++) {
        //         int square = (j - i) * Math.min(height[i], height[j]);
        //         max = Math.max(max, square);
        //     }
        // }
        // return max;

        int lt = 0;
        int rt = height.length - 1;
        int max = -1;
        while (lt < rt) { //O(n) O(1)
            int square = (rt - lt) * Math.min(height[rt], height[lt]);
            max = Math.max(max, square);
            if (height[lt] < height[rt]) {
                lt++;
            } else if (height[lt] > height[rt]) {
                rt--;
            } else {
                lt++;
                rt--;
            }
        }
        return max;
    }
}
