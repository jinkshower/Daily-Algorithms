package review;

import java.util.Arrays;

public class buzzbil2 {
    public static int minCostPath(int[] cost, int k) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = Math.max(0, i - k); j < i; j++) {
                if (dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + cost[i - j]);
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] cost = {4, 3, 9, 3, 1};
        int k = 2;

        int result = minCostPath(cost, k);
        System.out.println("최소 비용: " + result);
    }
}
