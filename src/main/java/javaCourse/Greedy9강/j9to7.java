package javaCourse.Greedy9강;

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

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    static int find(int x) {
        if (x == unf[x]) {
            return x;
        } else {
            return unf[x] = find(unf[x]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
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

        int answer = 0;
        int cnt = 0;
        Collections.sort(list);
        for (Edge e : list) {
            if (cnt == n - 1) {
                break;// 트리의간선개수 ? n-1
            }
            int fv1 = find(e.v1);
            int fv2 = find(e.v2);
            if (fv1 != fv2) {
                answer += e.cost;
                union(e.v1, e.v2);
                cnt++;
            }
        }
        System.out.println(answer);
    }
}
