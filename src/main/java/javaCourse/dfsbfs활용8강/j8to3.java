package javaCourse.dfsbfs활용8강;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class j8to3 {

    static int n, m;
    static List<Node> list = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;

    static void dfs(int L, int sum, int timeSum, List<Node> list) {
        if (timeSum > m) {
            return;
        }
        if (L == n) {
            answer = Math.max(sum, answer);
        } else {
            dfs(L + 1, sum + list.get(L).point, timeSum + list.get(L).time, list);
            dfs(L + 1, sum, timeSum, list);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(new Node(a, b));
        }

        dfs(0, 0, 0, list);
        System.out.println(answer);
    }

    static class Node {

        public int point;
        public int time;

        Node(int point, int time) {
            this.point = point;
            this.time = time;
        }
    }
}
