package javaCourse.RecursiveTreeGraph7강;

import java.util.Scanner;

public class j7to1 {

    static void dfs(int n) {
        if (n == 0) {
            return;
        } else {
            dfs(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dfs(n);
    }
}
