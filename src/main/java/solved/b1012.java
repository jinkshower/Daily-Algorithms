package solved;

import java.util.Scanner;

public class b1012 {

    public static int t;
    public static int m, n, k;
    public static Scanner sc = new Scanner(System.in);

    public static boolean dfs(int x, int y, int[][] graph) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        if (graph[x][y] == 1) {
            graph[x][y] = 0;
            dfs(x - 1, y, graph);
            dfs(x + 1, y, graph);
            dfs(x, y - 1, graph);
            dfs(x, y + 1, graph);
            return true;
        }
        return false;
    }

    public static void solve(int[][] graph) {
        for (int i = 0; i < k; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = 1;
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, graph)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {

        t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            m = sc.nextInt();
            n = sc.nextInt();
            k = sc.nextInt();

            int[][] graph = new int[m][n];
            solve(graph);
        }
    }
}
