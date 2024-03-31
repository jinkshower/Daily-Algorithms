package tryagain;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//미로 최단거리 bfs 다시풀기
public class j8to11 {

    static class Node {

        public int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map = new int[7][7];
    static int[][] ch = new int[7][7];
    static int[][] distance = new int[7][7];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer;

    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx > 6 || ny < 0 || ny > 6) {
                    continue;
                }
                if (ch[nx][ny] == 0 && map[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    distance[nx][ny] = distance[cur.x][cur.y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        ch[0][0] = 1;
        bfs(0, 0);
        if (distance[6][6] == 0) {
            System.out.println(-1);
            return;
        }
        System.out.println(distance[6][6]);
    }
}
