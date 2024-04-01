package tryagain;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class j8to14 {

    static int n;
    static int[][] map;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        map[start.x][start.y] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                if (map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    static class Node {

        public int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    bfs(new Node(i, j));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
