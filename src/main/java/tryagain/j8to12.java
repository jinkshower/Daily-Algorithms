package tryagain;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

//토마토 다시풀기
public class j8to12 {

    public static void bfs(List<Node> start) {
        Queue<Node> q = new LinkedList<>();
        for (Node n : start) {
            q.offer(n);
        }

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                if (box[nx][ny] == 0) {
                    box[nx][ny] = 1;
                    q.offer(new Node(nx, ny, cur.day + 1));
                    answer = cur.day + 1;
                }
            }
        }
    }

    static int answer;
    static int n, m;
    static int[][] box;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        box = new int[m][n];

        List<Node> start = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) {
                    start.add(new Node(i, j, 0));
                }
                box[i][j] = tmp;
            }
        }
        bfs(start);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(answer);
    }

    static class Node {

        public int x, y, day;

        Node(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
}
