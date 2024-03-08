package CodingPractice;

import java.util.Stack;

public class p131704 {

    public int solution(int[] order) {
        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= order.length; i++) {
            stack.push(i);
            while (!stack.isEmpty()) {
                if (stack.peek() == order[idx]) {
                    stack.pop();
                    idx++;
                } else {
                    break;
                }
            }
        }
        return idx;
    }
}
