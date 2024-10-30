package interview;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Stack;
import org.junit.jupiter.api.Test;

public class j22 {

    @Test
    public void test() {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        assertThat(queue.size()).isEqualTo(4);

        assertThat(queue.poll()).isEqualTo(1);
        assertThat(queue.poll()).isEqualTo(2);
        assertThat(queue.poll()).isEqualTo(3);
        assertThat(queue.poll()).isEqualTo(4);

        assertThat(queue.size()).isEqualTo(0);
    }


    public class MyQueue<T> {
        private Stack<T> stack1;
        private Stack<T> stack2;

        public MyQueue() {
            stack1 = new Stack<T>();
            stack2 = new Stack<T>();
        }

        public void offer(T elm) {
//             1. 아예 stack2를 queue와 동일하게 데이터를 저장하는 방법
//            while (!stack2.isEmpty()) {
//                stack1.push(stack2.pop());
//            }
//            stack1.push(elm);
//
//            while (!stack1.isEmpty()) {
//                stack2.push(stack1.pop());
//            }

            // 2. poll할 때만 queue처럼 반환하는 방법
            stack1.push(elm);
        }

        public T poll() {
//             1. 아예 stack2를 queue와 동일하게 데이터를 저장하는 방법
//            return stack2.pop();

//             2. poll할 때만 queue처럼 반환하는 방법
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();

        }

        public int size() {
//             1. 아예 stack2를 queue와 동일하게 데이터를 저장하는 방법
//            return stack2.size();

//             2. poll할 때만 queue처럼 반환하는 방법
            return stack1.size() + stack2.size();
        }
    }
}
