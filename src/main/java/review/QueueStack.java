package review;

import java.util.LinkedList;
import java.util.Queue;

public class QueueStack {
    Queue<Integer> left;
    Queue<Integer> right;

    QueueStack() {
        left = new LinkedList<>();
        right = new LinkedList<>();
    }

    public void push(int x) {
        left.offer(x);
    }

    public int poll() {
        while (left.size() > 1) {
            right.offer(left.poll());
        }
        int top = left.poll();

        Queue<Integer> tmp = left;
        left = right;
        right = tmp;
    }
}
