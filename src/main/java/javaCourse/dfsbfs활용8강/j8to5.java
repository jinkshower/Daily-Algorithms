package javaCourse.dfsbfs활용8강;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class j8to5 {

    static int n, m;
    static int answer = Integer.MAX_VALUE;

    static void dfs(int L, int sum, Integer[] coins) {
        if (sum > m) { //백트래킹
            return;
        }
        if (L >= answer) {//백트래킹
            return;
        }
        if (sum == m) {
            answer = Math.min(answer, L);
        } else {
            for (int i = 0; i < n; i++) {
                dfs(L + 1, sum + coins[i], coins);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Integer[] coins = new Integer[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins, Collections.reverseOrder()); //큰 금액부터 탐색하게
        m = sc.nextInt();
        dfs(0, 0, coins);
        System.out.println(answer);
    }
}
