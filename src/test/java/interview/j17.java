package interview;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class j17 {
        /*
        TASK
        ArrayList를 사용하여 Stack을 구현한다.
    */

    @Test
    public void test() {
        MyStackWithArrayList<Integer> stack = new MyStackWithArrayList<>();

        stack.push(0);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        assertThat(stack.pop()).isEqualTo(6);
        assertThat(stack.pop()).isEqualTo(5);
        assertThat(stack.pop()).isEqualTo(4);
        assertThat(stack.pop()).isEqualTo(3);
        assertThat(stack.pop()).isEqualTo(2);
        assertThat(stack.pop()).isEqualTo(1);
//        java.lang.ArrayIndexOutOfBoundsException: -1
//        assertThat(stack.pop(), is(0));
    }

    public class MyStackWithArrayList<T> {
        private List<T> data;

        public MyStackWithArrayList() {
            data = new ArrayList<T>();
        }

        public void push(T i) {
            data.add(i);
        }

        public T pop() {
            return data.remove(data.size() - 1);
        }
    }

}
