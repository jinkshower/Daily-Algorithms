package tryagain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class j9to1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            list.add(new Node(h, w));
        }

        Collections.sort(list);

        int max = 0;
        int cnt = 0;
        for (Node k : list) {
            if (k.weight > max) {
                cnt++;
                max = k.weight;
            }
        }
        System.out.println(cnt);
    }

    static class Node implements Comparable<Node> {

        public int height, weight;

        Node(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return o.height - this.height;
        }
    }
}
