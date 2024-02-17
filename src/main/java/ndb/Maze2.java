package ndb;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze2 {

    static int n, m;
    static int[][] map;
    static int[][] distance;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, 1, -1, 0};

    private static void bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        visited[1][1] = true;
        distance[1][1] = 1;

        while (!q.isEmpty()) {
            Node current = q.poll();
            int x = current.getX();
            int y = current.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || nx > n || ny < 1 | ny > m) {
                    continue;
                }
                if (map[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n + 1][m + 1];
        distance = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String str = sc.next();
            for (int j = 1; j <= m; j++) {
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }
        Node start = new Node(1, 1);
        bfs(start);
        System.out.println(distance[n][m]);
    }

    static class Node {

        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return this.x;
        }

        int getY() {
            return this.y;
        }
    }
}
