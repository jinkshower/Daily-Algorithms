package CodingPractice;

import java.util.LinkedList;
import java.util.Queue;

public class p42587 {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.offer(new Node(priorities[i], i));
        }

        int cnt = 1;
        while (!q.isEmpty()) {
            int tmp = 0;
            int a = q.peek().pr;
            for (Node n : q) {
                if (n.pr > a) {
                    tmp++;
                }
            }
            if (tmp != 0) {
                Node cur = q.poll();
                q.offer(cur);
            } else {
                Node cur = q.poll();
                if (cur.idx == location) {
                    return cnt;
                }
                cnt++;
            }
        }
        return answer;
    }

    static class Node {

        public int pr;
        public int idx;

        Node(int pr, int idx) {
            this.pr = pr;
            this.idx = idx;
        }
    }
}
