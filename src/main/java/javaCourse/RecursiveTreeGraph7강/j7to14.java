package javaCourse.RecursiveTreeGraph7강;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class j7to14 {

    static int n, m;
    static List<List<Integer>> graph;
    static int[] ch, dis;

    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        ch[v] = 1;
        dis[v] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nv : graph.get(cur)) {
                if (ch[nv] == 0) {
                    ch[nv] = 1;
                    q.offer(nv);
                    dis[nv] = dis[cur] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        ch = new int[n + 1];
        dis = new int[n + 1];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        bfs(1);
        for (int x : dis) {
            System.out.println(x);
        }
    }
}
