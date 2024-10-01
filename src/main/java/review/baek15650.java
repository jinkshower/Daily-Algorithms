package review;

import java.util.Scanner;

public class baek15650 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//1~ n
        int m = scanner.nextInt();// 중복 x m개 오름차순
        int[] arr = new int[m];
        boolean[] visited = new boolean[n + 1];
        recur(0, 1, n, m, arr);
    }

    private static void recur(int depth, int start, int n, int m, int[] arr) {
        if (depth == m) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n + 1; i++) {
            arr[depth] = i;
            recur(depth + 1, i + 1, n, m, arr);
        }
    }
}
