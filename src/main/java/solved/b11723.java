package solved;

import java.util.Scanner;

public class b11723 {

    static int n, m;
    static int[][] graph;
    static boolean[] visited;

    private static void dfs(int x) {
        if (visited[x]) {
            return;
        } else {
            visited[x] = true;
            for (int i = 1; i <= n; i++) {
                if (graph[x][i] == 1) {
                    dfs(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        visited = new boolean[n + 1];

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
}
