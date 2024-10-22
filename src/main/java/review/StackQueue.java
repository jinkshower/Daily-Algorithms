package review;

import java.util.Stack;

public class StackQueue {
    Stack<Integer> left;
    Stack<Integer> right;

    public StackQueue() {
        left = new Stack<>();
        right = new Stack<>();
    }

    public void offer(int x) {
        left.push(x);
    }

    public int poll() {
        if (right.isEmpty()) {
            while (!left.isEmpty()) {
                right.push(left.pop());
            }
        }
        return right.pop();
    }
}
