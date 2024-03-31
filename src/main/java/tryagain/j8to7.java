package tryagain;

import java.util.Scanner;

//조합수 구하기 다시풀기
public class j8to7 {

    static int[][] dp;

    public static int dfs(int n, int r) {
        if (dp[n][r] != 0) {
            return dp[n][r];
        }
        if (n == r || r == 0) {
            return dp[n][r] = 1;
        }
        return dp[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//n에서 m개 뽑기
        int m = sc.nextInt();
        dp = new int[n + 1][m + 1];
        int answer = dfs(n, m);
        System.out.println(answer);
    }
}
