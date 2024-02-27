package javaCourse.dfsbfs활용8강;

import java.util.Scanner;

public class j8to7 {

    static int[][] dy;

    static int dfs(int n, int r) {
        if (dy[n][r] > 0) {
            return dy[n][r];
        }
        if (n == r || r == 0) {
            return 1;
        } else {
            return dy[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        dy = new int[n + 1][n + 1];
        int answer = dfs(n, r);
        System.out.println(answer);
    }
}
