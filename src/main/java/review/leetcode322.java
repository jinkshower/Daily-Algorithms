package review;

import java.util.Arrays;

public class leetcode322 {
    static int[] dp;

    public int coinChange(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int result = backtrack(coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int backtrack(int[] coins, int amount) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (dp[amount] != -1) {
            return dp[amount];
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = backtrack(coins, amount - coin);

            if (result != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, result + 1);
            }
        }

        dp[amount] = minCoins;
        return dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {
        dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[amount] = 0;

        int result = backtrack2(coins, 0, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int backtrack2(int[] coins, long value, int goal) {
        if (value > goal) {
            return Integer.MAX_VALUE;
        }

        if (dp[(int) value] != -1) {
            return dp[(int) value];
        }

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            long newValue = value + coin;

            if (newValue <= goal) {
                int result = backtrack2(coins, value + coin, goal);
                if (result != Integer.MAX_VALUE) {
                    minCoins = Math.min(minCoins, result + 1);
                }
            }
        }

        dp[(int) value] = minCoins;
        return dp[(int) value];
    }

    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) { // amount 마다 구했음.
            for (int coin : coins) { // coin을 써서 뺄거임
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) { // 재귀 기저 조건 옮기기
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
