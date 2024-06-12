package javaCourse.dfsbfs활용8강;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class j8to15 {

    static int n, m, answer = Integer.MAX_VALUE;
    static List<Node> hs = new ArrayList<>();
    static List<Node> pz = new ArrayList<>();
    static int[] combi;

    static void dfs(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (Node h : hs) {
                int dis = Integer.MAX_VALUE;
                for (int x : combi) {
                    Node p = pz.get(x);
                    int tmp = Math.abs(h.x - p.x) + Math.abs(h.y - p.y);
                    dis = Math.min(dis, tmp);
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < pz.size(); i++) {
                combi[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt(); // 최대 피자 집 개수
        combi = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = sc.nextInt();
                if (a == 1) {
                    hs.add(new Node(i, j));
                } else if (a == 2) {
                    pz.add(new Node(i, j));
                }
            }
        }
        dfs(0, 0);
        System.out.println(answer);
    }

    static class Node {

        public int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
