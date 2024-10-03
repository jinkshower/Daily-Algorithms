package review;

public class alphacode {
    public int solution(String s) {
        dp = new int[101];
        return recur(0, s);
    }

    int[] dp;

    public int recur(int idx, String s) {
        if (dp[idx] > 0) {
            return dp[idx];
        }
        if (idx < s.length() && s.charAt(idx) == '0') {
            return 0;
        }
        if (idx == s.length()) {
            return 1;
        }
        if (idx == s.length() - 1) {
            return 1;
        }

        int result = recur(idx + 1, s);

        int tmp = Integer.parseInt(s.substring(idx, idx + 2));
        if (tmp <= 26) {
            result += recur(idx + 2, s);
        }
        return dp[idx] = result;
    }
}
