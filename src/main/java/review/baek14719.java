package review;

import java.util.Scanner;

public class baek14719 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] heights = new int[m];

        int maxHeight = 0;
        int maxIdx = 0;
        int stones = 0;

        for (int i = 0; i < m; i++) {
            int cur = scanner.nextInt();
            if (cur > maxHeight) {
                maxHeight = cur;
                maxIdx = i;
            }
            heights[i] = cur;
            stones += cur;
        }

        int area = 0;
        int leftMax = 0;
        for (int i = 0; i <= maxIdx; i++) {
            leftMax = Math.max(leftMax, heights[i]);
            area += leftMax;
        }

        int rightMax = 0;

        for (int i = m - 1; i > maxIdx; i--) {
            rightMax = Math.max(rightMax, heights[i]);
            area += rightMax;
        }

        System.out.println(area - stones);

    }
}
