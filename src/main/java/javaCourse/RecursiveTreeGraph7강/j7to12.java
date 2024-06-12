package javaCourse.RecursiveTreeGraph7강;

import java.util.Scanner;

public class j7to12 {

    static int n, m, answer;
    static int[][] graph;
    static int[] ch;

    static void dfs(int L) {
        if (L == n) {
            answer++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (graph[L][i] == 1 && ch[i] == 0) {
                    ch[i] = 1;
                    dfs(i);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n + 1][n + 1];
        ch = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
        }

        ch[1] = 1;
        dfs(1);
        System.out.println(answer);
    }
}
