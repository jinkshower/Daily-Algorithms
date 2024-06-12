package javaCourse.RecursiveTreeGraph7강;

import java.util.Scanner;

public class j7to4 {

    //메모이제이션
    static int[] fibo;

    static int dfs2(int n) {
        if (fibo[n] != 0) {
            return fibo[n]; //메모이제이션
        }
        if (n == 1) {
            return fibo[n] = 1;
        } else if (n == 2) {
            return fibo[n] = 1;
        } else {
            return fibo[n] = dfs(n - 2) + dfs(n - 1);
        }
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        fibo = new int[n + 1];
        dfs2(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }

    //재귀 dfs
    static int dfs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            return dfs(n - 2) + dfs(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print(dfs(i) + " ");
        }
    }
}
