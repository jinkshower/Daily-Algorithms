package review;

import java.util.Scanner;

public class baek11660 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] graph = new int[n][n];
        // x1 y1 x2 y2  2 2 3 4
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        int[][] prefix = new int[n][n];
        prefix[0][0] = graph[0][0];

        for (int i = 1; i < n; i++) {
            prefix[0][i] = prefix[0][i - 1] + graph[0][i];
        }
        for (int i = 1; i < n; i++) {
            prefix[i][0] = prefix[i - 1][0] + graph[i][0];
        }

        for (int i = 2; i < n; i++) {
            for (int j = 2; j < n; j++) {
                prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }
        //두번 뺀 대각선 왼쪽 위를 더해줘야 함.
//        return prefix[x2][y2] - prefix[x1 + 1][y1 - 1] - prefix[x2 - 1][ y2] + prefix[x2- 1][y2 - 1];

    }
}
