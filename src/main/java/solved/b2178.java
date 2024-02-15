package solved;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b2178 {

    static int n, m;
    static int[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    private static void bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);

        int x = 0;
        int y = 0;
        int distance = 0;
        while (!q.isEmpty()) {
            Node current = q.poll();
            x = current.getX();
            y = current.getY();

            //4방향으로 최단거리 기록
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //지도 밖으로 나갈때
                if (nx <= 0 || nx > n || ny <= 0 || ny > m) {
                    continue;
                }
                //벽일때
                if (graph[nx][ny] == 0) {
                    continue;
                }

                if (graph[nx][ny] == 1) {
                    //현재 위치 +1 저장
                    graph[nx][ny] = graph[x][y] + 1;
                    //큐에 넣기
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        graph = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String str = sc.nextLine();
            for (int j = 1; j <= m; j++) {
                graph[i][j] = str.charAt(j - 1) - '0';
            }
        }
        Node start = new Node(1, 1);
        bfs(start);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }

    static class Node {

        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }
}
