package review;

import java.util.Scanner;

public class baek14501dp {


    static int n;
    static int answer;
    static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        int[][] graph = new int[n][2];

        for (int i = 0; i < n; i++) {
            graph[i][0] = scanner.nextInt(); // 점프기간
            graph[i][1] = scanner.nextInt(); // 보상
        }
        dp = new int[n];

        recur(0, graph);

        System.out.println(dp[0]);
    }

    private static int recur(int depth, int[][] graph) {
        if (depth > n) {
            return Integer.MIN_VALUE;
        }

        if (depth == n) {
            return 0;
        }

        if (dp[depth] != 0) {
            return dp[depth];
        }

        // 상담을 하는 경우 안하는 경우의 최대값을 dp에 저장
        dp[depth] = Math.max(recur(depth + graph[depth][0], graph) + graph[depth][1], recur(depth + 1, graph));
        return dp[depth];
    }
}
