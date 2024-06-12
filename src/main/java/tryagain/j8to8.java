package tryagain;

import java.util.Scanner;

//수열 추측하기 다시풀기
public class j8to8 {

    static int[][] dp = new int[35][35];
    static int n, m;
    static int[] b, p, ch;
    static boolean flag = false;

    public static int combi(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        }
        return dp[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

    public static void dfs(int L, int sum) {
        if (flag) {
            return;
        }
        if (L == n) {
            if (sum == m) {
                for (int x : p) {
                    System.out.print(x + " ");
                }
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    p[L] = i;
                    dfs(L + 1, sum + (p[L] * b[L]));
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//윗줄 개수
        m = sc.nextInt();//목표 숫자
        b = new int[n];
        p = new int[n];
        ch = new int[n + 1];

        for (int i = 0; i < n; i++) {
            b[i] = combi(n - 1, i);
        }
        dfs(0, 0);
    }
}
