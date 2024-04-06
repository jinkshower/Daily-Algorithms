package tryagain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class j9to7 {

    static class Edge implements Comparable<Edge> {

        public int v1, v2, cost;

        Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] unf;
    static int n, m;

    static int find(int v) {
        if (unf[v] == v) {
            return v;
        }
        return unf[v] = find(unf[v]);
    }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //도시 개수
        m = sc.nextInt(); //도로 개수

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.add(new Edge(a, b, c));
        }

        Collections.sort(list);
        int sum = 0;
        for (Edge edge : list) {
            int fa = find(edge.v1);
            int fb = find(edge.v2);
            if (fa != fb) {
                union(edge.v1, edge.v2);
                sum += edge.cost;
            }
        }
        System.out.println(sum);
    }
}
