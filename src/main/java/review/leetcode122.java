package review;

public class leetcode122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        dp[0][0] = 0; // not holding
        dp[0][1] = -prices[0]; // holding first

        for (int i = 1; i < n; i++) {
            //i 번째날 주식을 가지지 않는 상태는
            //전날의 안산 상태를 유지, 전날의 산 주식을 파는 것 중 최대값.
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            //i번째 날 주식을 가지고 있는 상태는
            //전날의 산 상태를 유지, 전날의 안산 상태에서 주식을 i번째 주식을 사는 것
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0]; //주식을 다 팔아야 함.
    }
}
