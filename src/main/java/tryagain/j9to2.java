package tryagain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class j9to2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Node> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.add(new Node(start, end));
        }
        Collections.sort(list);
        int prevEnd = 0;
        int cnt = 0;
        for (Node node : list) {
            if (node.start >= prevEnd) {
                cnt++;
                prevEnd = node.end;
            }
        }
        System.out.println(cnt);
    }

    static class Node implements Comparable<Node> {

        public int start, end;

        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if (this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
}
