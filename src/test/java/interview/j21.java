package interview;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import org.junit.jupiter.api.Test;

public class j21 {

    @Test
    public void test() {
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        que.offer(2);
        que.offer(3);

        reverseQueue(que);

        assertThat(que.poll()).isEqualTo(3);
        assertThat(que.poll()).isEqualTo(2);
        assertThat(que.poll()).isEqualTo(1);
    }

    public Queue<Integer> reverseQueue(Queue<Integer> que) {
        Stack<Integer> stack = new Stack<>();
        while (!que.isEmpty()) {
            stack.push(que.poll());
        }
        while (!stack.isEmpty()) {
            que.offer(stack.pop());
        }
        return que;
    }
}
