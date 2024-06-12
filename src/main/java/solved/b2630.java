package solved;

import java.util.Scanner;

public class b2630 {

    public static int n;
    public static int blueCount, whiteCount;
    public static int[][] graph = new int[128][128];

    public static void solve(int x, int y, int size) {
        if (isAllSame(x, y, size) || size == 1) {
            if (isBlue(x, y)) {
                blueCount += 1;
            } else {
                whiteCount += 1;
            }
            return;
        }

        solve(x, y, size / 2);
        solve(x + size / 2, y + size / 2, size / 2);
        solve(x + size / 2, y, size / 2);
        solve(x, y + size / 2, size / 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        solve(0, 0, n);
        System.out.println(whiteCount);
        System.out.println(blueCount);
    }

    public static boolean isBlue(int x, int y) {
        return graph[x][y] == 1;
    }

    public static boolean isAllSame(int x, int y, int size) {
        boolean isAllSame = true;
        int first = graph[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (first != graph[i][j]) {
                    isAllSame = false;
                    break;
                }
            }
        }
        return isAllSame;
    }
}
