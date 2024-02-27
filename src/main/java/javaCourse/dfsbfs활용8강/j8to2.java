package javaCourse.dfsbfs활용8강;

import java.util.Scanner;

public class j8to2 {

    static int c, n; //c 최대무게
    static int[] dogs;
    static int max;

    static void dfs(int L, int sum, int[] dogs) {
        if (sum > c) {
            return;
        }
        if (L == n) {
            if (sum > max) {
                max = sum;
            }
        } else {
            dfs(L + 1, sum + dogs[L], dogs);
            dfs(L + 1, sum, dogs);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        dogs = new int[n];
        for (int i = 0; i < n; i++) {
            dogs[i] = sc.nextInt();
        }
        dfs(0, 0, dogs);
        System.out.println(max);
    }
}
