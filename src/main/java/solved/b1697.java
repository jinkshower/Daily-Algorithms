package solved;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b1697 {

    public static int n, k;
    public static int[] distance = new int[100001];

    public static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        distance[n] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = current - 1;
                } else if (i == 1) {
                    next = current + 1;
                } else {
                    next = current * 2;
                }

                if (next == k) {
                    System.out.println(distance[current] + 1);
                    return;
                }

                if (next >= 0 && next < distance.length && distance[next] == 0) {
                    q.offer(next);
                    distance[next] = distance[current] + 1;
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
        } else {
            bfs(n);
        }
    }
}
