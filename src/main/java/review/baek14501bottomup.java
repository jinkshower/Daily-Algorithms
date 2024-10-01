package review;

import java.util.Scanner;

public class baek14501bottomup {
    static int n;
    static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        int[][] graph = new int[n][2];

        for (int i = 0; i < n; i++) {
            graph[i][0] = scanner.nextInt(); // 점프기간
            graph[i][1] = scanner.nextInt(); // 보상
        }
        dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            if (i + graph[i][0] > n) {
                dp[i] = dp[i + 1];
                continue;
            }
            dp[i] = Math.max(dp[i + graph[i][0]] + graph[i][1], dp[i + 1]);
        }

        System.out.println(dp[0]);
    }
}
