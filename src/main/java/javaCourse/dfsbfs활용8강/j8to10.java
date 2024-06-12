package javaCourse.dfsbfs활용8강;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class j8to10 {

    static int[][] board, dis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void bfs(int a, int b) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(a, b));
        board[a][b] = 1;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 1 || nx > 7 || ny < 1 || ny > 7) {
                    continue;
                }
                if (board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    dis[nx][ny] = dis[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        board = new int[8][8];
        dis = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        bfs(1, 1);
        int answer = dis[7][7] == 0 ? -1 : dis[7][7];
        System.out.println(answer);
    }

    static class Node {

        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
