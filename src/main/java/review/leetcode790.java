package review;

public class leetcode790 {

    private static final int MODULO = 1000000007;

    public int numTilings(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = (2 * dp[i - 1] % MODULO + dp[i - 3] % MODULO) % MODULO;
        }
        return dp[n];
    }
}
