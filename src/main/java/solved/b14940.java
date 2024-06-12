package solved;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b14940 {

    static int n, m;
    static int[][] map;
    static int[][] distance;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    private static void bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);
        int x = start.getX();
        int y = start.getY();

        while (!q.isEmpty()) {
            //현재 지점 꺼내기
            Node current = q.poll();
            //x,y 갱신
            x = current.getX();
            y = current.getY();
            //4방향
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                //범위 벗어나면 제외
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                //갈수 없는 지점 이나 출발지점 제외
                if (map[nx][ny] == 2 || map[nx][ny] == 0) {
                    continue;
                }

                //기록되지 않은 땅이면
                if (distance[nx][ny] == 0) {
                    //현재 지점 + 1 거리기록
                    distance[nx][ny] = distance[x][y] + 1;
                    map[nx][ny] = -1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        map = new int[n][m];
        distance = new int[n][m];

        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int t = sc.nextInt();
                if (t == 2) {
                    a = i;
                    b = j;// 출발점 기록
                }
                map[i][j] = t;
            }
        }

        Node start = new Node(a, b);
        bfs(start);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int k = distance[i][j];
                if (map[i][j] == 1) {
                    // System.out.print(-1 + " ");
                    sb.append(-1).append(" ");
                } else {
                    // System.out.print(k + " ");
                    sb.append(k).append(" ");
                }
            }
            // System.out.println();
            sb.append("\n");
        }
        System.out.println(sb);
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
