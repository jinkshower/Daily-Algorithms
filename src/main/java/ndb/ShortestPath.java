package ndb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ShortestPath {

    static int n, m, k, x;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] distance;
    static boolean[] visited;

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        distance[start] = 0;
        visited[start] = true;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int i = 0; i < graph.get(current).size(); i++) {
                int next = graph.get(current).get(i);

                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[current] + 1;
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        distance = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        bfs(x);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == k) {
                sb.append(i).append("\n");
            }
        }
        if (sb.toString().isEmpty()) {
            System.out.println(-1);
            return;
        }
        System.out.println(sb);
    }
}
