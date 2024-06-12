package solved;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b21736 {

    static int n, m;
    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int count;

    static void bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        int x = start.getX();
        int y = start.getY();
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();
            x = current.getX();
            y = current.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 1 || nx > n || ny < 1 || ny > m) {
                    continue;
                }

                if (graph[nx][ny] != -1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (graph[nx][ny] == 1) {
                        count++;
                    }
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];

        int x = 0;
        int y = 0;
        for (int i = 1; i <= n; i++) {
            String str = sc.next();
            for (int j = 1; j <= m; j++) {
                char c = str.charAt(j - 1);
                if (c == 'O') {
                    graph[i][j] = 0;
                } else if (c == 'P') {
                    graph[i][j] = 1;
                } else if (c == 'X') {
                    graph[i][j] = -1;
                } else {
                    x = i;
                    y = j;
                }
            }
        }
        count = 0;
        Node start = new Node(x, y);
        bfs(start);

        String answer = (count > 0) ? count + "" : "TT";
        System.out.println(answer);
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
