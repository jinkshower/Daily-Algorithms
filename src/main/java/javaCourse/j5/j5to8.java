package javaCourse.j5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class j5to8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Node> list = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            Node node = new Node(cur, i);
            list.add(node);
            q.offer(node);
        }

        Collections.sort(list);

        int answer = 1;
        int lt = 0;
        while (true) {
            Node current = q.poll();
            int top = list.get(lt).getValue();
            if (current.getValue() == top) {
                if (current.getIdx() == m) {
                    break;
                } else {
                    answer++;
                    lt++;
                }
            } else {
                q.offer(current);
            }
        }

        System.out.println(answer);
    }

    static class Node implements Comparable<Node> {

        int value;
        int idx;

        Node(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        int getValue() {
            return this.value;
        }

        int getIdx() {
            return this.idx;
        }

        @Override
        public int compareTo(Node other) {
            return other.getValue() - this.value;
        }
    }
}
