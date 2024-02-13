package solved;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class b2606 {

    public static int n, m; //n 노드 m 간선
    public static List<List<Integer>> graph = new ArrayList<>();
    public static boolean[] visited = new boolean[101];

    public static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        int count = 0;
        while (!q.isEmpty()) {
            int current = q.poll();

            for (int i = 0; i < graph.get(current).size(); i++) {
                int next = graph.get(current).get(i);
                if (!visited[next]) {
                    visited[next] = true;
                    count++;
                    q.offer(next);
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int count = 0;
        count = bfs(1);
        System.out.println(count);
    }
}
