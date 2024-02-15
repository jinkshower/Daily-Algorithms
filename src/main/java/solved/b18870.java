package solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class b18870 {

    static int n;

    static class Node implements Comparable<Node> {

        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return this.value;
        }

        public int getIndex() {
            return this.index;
        }

        @Override
        public int compareTo(Node other) {
            return this.value - other.getValue();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            list.add(new Node(t, i));
        }

        Collections.sort(list);
        //첫번째 node 기록
        int[] answer = new int[n];
        int count = 0;
        Node node = list.get(0);
        int index = node.getIndex();
        int value = node.getValue();
        answer[index] = 0;
        // 정렬된 순서대로 기록, value가 같다면 count도 같음
        for (int i = 1; i < list.size(); i++) {
            node = list.get(i);
            index = node.getIndex();
            // 더 큰 value가 나오면
            if (node.getValue() != value) {
                count++;
                value = node.getValue();
            }
            answer[index] = count;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i] + " ");
        }
        System.out.println(sb);
    }
}
