package solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class b2667 {

    static int n;
    static int[][] graph;
    static boolean[][] visited;
    static List<Integer> houses = new ArrayList<>();

    private static int dfs(int x, int y, int house) {
        if (x <= 0 || x > n || y <= 0 || y > n) {
            return house;
        }
        if (visited[x][y]) {
            return house;
        }
        if (graph[x][y] == 1) {
            visited[x][y] = true;
            house++;

            house = dfs(x - 1, y, house);
            house = dfs(x, y - 1, house);
            house = dfs(x + 1, y, house);
            house = dfs(x, y + 1, house);

            return house;
        }
        return house;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String str = sc.nextLine();
            for (int j = 1; j <= n; j++) {
                graph[i][j] = str.charAt(j - 1) - '0';
            }
        }

        int count = 0;
        int house = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 1) {
                    int result = dfs(i, j, 0);
                    if (result != 0) {
                        count++;
                        houses.add(result);
                    }
                }
            }
        }
        System.out.println(count);
        Collections.sort(houses);
        for (int x : houses) {
            System.out.println(x);
        }
    }
}
