package tryagain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class j9to3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int in = sc.nextInt();
            int out = sc.nextInt();
            list.add(new Node(in, 'b'));
            list.add(new Node(out, 'a'));
        }
        Collections.sort(list);

        int cnt = 0;
        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            Node cur = list.get(i);
            if (cur.inout == 'a') {
                cnt--;
            } else {
                cnt++;
            }
            answer = Math.max(cnt, answer);
        }
        System.out.println(answer);
    }

    static class Node implements Comparable<Node> {

        public int time;
        public char inout;

        Node(int time, char inout) {
            this.time = time;
            this.inout = inout;
        }

        @Override
        public int compareTo(Node o) {
            if (this.time == o.time) {
                return this.inout - o.inout;
            }
            return this.time - o.time;
        }
    }
}
