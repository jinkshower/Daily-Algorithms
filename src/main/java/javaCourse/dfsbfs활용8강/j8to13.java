package javaCourse.dfsbfs활용8강;

import java.util.Scanner;

public class j8to13 {

    static int[][] board;
    static int n;

    static boolean dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= n) {
            return false;
        }
        if (board[x][y] == 0) {
            return false;
        } else {
            board[x][y] = 0;
            dfs(x - 1, y);
            dfs(x, y - 1);
            dfs(x + 1, y);
            dfs(x, y + 1);
            dfs(x - 1, y - 1);
            dfs(x - 1, y + 1);
            dfs(x + 1, y - 1);
            dfs(x + 1, y + 1);
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j)) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}

class j8to13to2 {

    static int[][] board;
    static int n;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static void dfs(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                    cnt++;
                    dfs(i, j);
                }
            }
        }
        System.out.println(cnt);
    }
}
