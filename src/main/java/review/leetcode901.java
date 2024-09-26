package review;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode901 {
    class StockSpanner {

        Deque<int[]> stack;
        int counter;

        public StockSpanner() {
            stack = new ArrayDeque<>();
            counter = -1;
        }

        public int next(int price) {
            counter++;
            while (!stack.isEmpty() && stack.peek()[1] <= price) {
                int[] top = stack.pop();
            }
            int tmp = -1;
            if (!stack.isEmpty()) {
                tmp = stack.peek()[0];
            }

            stack.push(new int[]{counter, price});
            return counter - tmp;
        }
    }
}
