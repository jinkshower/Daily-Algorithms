package solved;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b1389 {

    static int n, m; //n 노드 m 무방향간선
    static int[][] graph;
    static int[] distance;
    static boolean[] visited;

    public static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);

        int sum = 0;
        while (!q.isEmpty()) {
            int current = q.poll();

            for (int i = 1; i < graph.length; i++) {
                if (graph[current][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    distance[i] = distance[current] + 1;
                    sum += distance[i];
                    q.offer(i);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        int min = 5001;
        int index = 0;

        for (int i = 1; i <= n; i++) {
            distance = new int[n + 1];
            visited = new boolean[n + 1];
            int thisBacon = bfs(i);
            if (thisBacon < min) {
                min = thisBacon;
                index = i;
            }
        }
        System.out.println(index);
    }
}
