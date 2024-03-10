package CodingPractice;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class p154540 {

    static int[][] graph;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static PriorityQueue<Integer> answer = new PriorityQueue<>();

    public void bfs(Node start) {
        Queue<Node> q = new LinkedList<>();
        q.offer(start);

        int sum = 0;
        sum += graph[start.x][start.y];
        graph[start.x][start.y] = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= graph.length || ny < 0 || ny >= graph[0].length) {
                    continue;
                }
                if (graph[nx][ny] != 0) {
                    sum += graph[nx][ny];
                    graph[nx][ny] = 0;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        answer.offer(sum);
    }

    public int[] solution(String[] maps) {
        graph = new int[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                char c = maps[i].charAt(j);
                if (c == 'X') {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = c - '0';
                }
            }
        }
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] != 0) {
                    bfs(new Node(i, j));
                }
            }
        }
        int len = answer.size();
        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            result[i] = answer.poll();
        }
        return len == 0 ? new int[]{-1} : result;
    }

    class Node {

        public int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
