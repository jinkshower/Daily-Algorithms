package review;

import java.util.Scanner;

public class baek2304 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] heights = new int[1001];

        int maxPosition = 0;
        int maxHeight = 0;
        int maxIdx = 0;

        for (int i = 0; i < n; i++) {
            int position = scanner.nextInt();
            int height = scanner.nextInt();
            heights[position] = height;

            if (height > maxHeight) {
                maxHeight = height;
                maxIdx = position;
            }
            maxPosition = Math.max(maxPosition, position);
        }

        int area = 0;
        int leftMax = 0;

        for (int i = 0; i <= maxIdx; i++) {
            leftMax = Math.max(leftMax, heights[i]);
            area += leftMax;
        }

        int rightMax = 0;
        for (int i = maxPosition; i > maxIdx; i--) {
            rightMax = Math.max(rightMax, heights[i]);
            area += rightMax;
        }

        System.out.println(area);
    }
}
