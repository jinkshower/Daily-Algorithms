package solved;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b1697 {

    static int n, k;
    static int[] distance = new int[100001];
    static boolean[] visited = new boolean[100001];

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int current = q.poll();

            int next;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    next = current - 1;
                } else if (i == 1) {
                    next = current + 1;
                } else {
                    next = current * 2;
                }

                if (next < 0 || next > 100000) {
                    continue;
                }

                if (next == k) {
                    distance[next] = distance[current] + 1;
                    System.out.println(distance[next]);
                    return;
                }

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
        k = sc.nextInt();

        if (n == k) {
            System.out.println(0);
            return;
        }

        bfs(n);
    }
}
