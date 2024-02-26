package javaCourse.RecursiveTreeGraph7강;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class j7to8 {

    static int n, m;
    static int[] distance = new int[10001];
    static boolean[] visited = new boolean[10001];

    static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            int next = -1;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    next = cur + 1;
                } else if (i == 1) {
                    next = cur - 1;
                } else {
                    next = cur + 5;
                }
                if (next == m) {
                    distance[next] = distance[cur] + 1;
                    System.out.println(distance[next]);
                    return;
                }
                if (next < 0 || next > 10000) {
                    continue;
                }
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        bfs(n);
    }

    //강의 풀이
    static int bfs(int s, int e) {
        int[] ch = new int[10001];
        ch[s] = 1;
        Queue<Integer> q = new LinkedList<>();
        int[] dis = new int[10001];
        q.offer(s);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int x = q.poll();
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if (x == e) {
                        return L + 1;
                    }
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }
}
