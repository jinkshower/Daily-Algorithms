package review;

public class leetcode72 {

    public int minDistance(String word1, String word2) {
        // same. find Longest Common Subsequence.
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= word1.length(); i++) {
            dp[i][word2.length()] = m - i;
        }

        for (int i = 0; i <= word2.length(); i++) {
            dp[word1.length()][i] = n - i;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], Math.min(dp[i + 1][j + 1], dp[i][j + 1]));
                }
            }
        }
        return dp[0][0];
    }
}
