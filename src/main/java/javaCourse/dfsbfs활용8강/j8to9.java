package javaCourse.dfsbfs활용8강;

import java.util.Scanner;

public class j8to9 {

    static int n, m;
    static int[] combi;

    static void dfs(int L, int S) {
        if (L == m) {
            for (int x : combi) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = S; i <= n; i++) {
                combi[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[m];
        dfs(0, 1);
    }
}
