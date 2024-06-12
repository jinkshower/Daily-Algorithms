package ndb;

import java.util.Scanner;

public class IcedJuice2 {

    static int n, m;
    static int[][] graph;
    static boolean[][] visited;

    private static boolean dfs(int x, int y) {
        if (x < 1 || x > n || y < 1 || y > m) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }
        if (graph[x][y] == 0) {
            visited[x][y] = true;

            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String str = sc.next();
            for (int j = 1; j <= m; j++) {
                graph[i][j] = str.charAt(j - 1) - '0';
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dfs(i, j)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
