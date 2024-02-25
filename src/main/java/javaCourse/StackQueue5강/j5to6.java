package javaCourse.StackQueue5강;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class j5to6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                int m = q.poll();
                q.offer(m);
            }
            q.poll();
        }
        System.out.println(q.poll());
    }
}
