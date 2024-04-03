package tryagain;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class j9to4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<Node> pq1 = new PriorityQueue<>();
        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            int money = sc.nextInt();
            int day = sc.nextInt();
            pq1.offer(new Node(money, day));
            maxDay = Math.max(maxDay, day);
        }
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        int sum = 0;
        for (int i = maxDay; i >= 1; i--) {
            while (!pq1.isEmpty() && pq1.peek().day == i) {
                pq2.offer(pq1.poll().money);
            }
            if (!pq2.isEmpty()) {
                int cur = pq2.poll();
                sum += cur;
            }
        }
        System.out.println(sum);
    }

    static class Node implements Comparable<Node> {

        public int money, day;

        Node(int money, int day) {
            this.money = money;
            this.day = day;
        }

        @Override
        public int compareTo(Node o) {
            if (this.day == o.day) {
                return o.money - this.money;
            }
            return o.day - this.day;
        }
    }
}
