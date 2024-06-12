package javaCourse.RecursiveTreeGraph7강;

import java.util.Scanner;

public class j7to3 {

    static int dfs(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * dfs(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = dfs(n);
    }
}
