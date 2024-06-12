package solved;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class b7576 {

    public static int m, n;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    static class Node {

        int x;
        int y;
        int day;

        public Node(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public int getDay() {
            return this.day;
        }
    }

    public static int bfs() {
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < first.size(); i++) {
            q.offer(first.get(i));
        }

        int x, y;
        int day = 0;
        while (!q.isEmpty()) {
            Node current = q.poll();
            x = current.getX();
            y = current.getY();
            day = current.getDay();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (graph[nx][ny] == -1) {
                    continue;
                }

                if (graph[nx][ny] == 0) {
                    graph[nx][ny] = 1;
                    Node node = new Node(nx, ny, day + 1);
                    q.offer(node);
                }
            }
        }
        return day;
    }

    public static int[][] graph = new int[1000][1000];
    public static List<Node> first = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int t = sc.nextInt();
                if (t == 1) {
                    Node node = new Node(i, j, 0);
                    first.add(node);
                }
                graph[i][j] = t;
            }
        }

        int day = bfs();
        if (allRiped()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    static boolean allRiped() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
