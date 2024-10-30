package interview;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;
import org.junit.jupiter.api.Test;

public class j18 {
        /*
        TASK
        Stack에 저장된 값들 중 최소값을 반환하는 minStack() 함수를 구현한다.
     */

    @Test
    public void test() {
        MyStack stack = new MyStack();
        stack.push(3);
        stack.push(5);
        stack.push(4);
        stack.push(2);
        stack.push(6);

        assertThat(stack.min()).isEqualTo(2);
    }

    public class MyStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MyStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int newVal) {
            if (minStack.isEmpty() || newVal <= minStack.peek()) {
                minStack.push(newVal);
            }
            stack.push(newVal);
        }

        public int pop() {
            int val = stack.pop();
            if (!minStack.isEmpty() && val == minStack.peek()) {
                minStack.pop();
            }
            return val;
        }

        public int min() {
            if (minStack.isEmpty()) {
                throw new RuntimeException("");
            }
            return minStack.peek();
        }
    }
}
