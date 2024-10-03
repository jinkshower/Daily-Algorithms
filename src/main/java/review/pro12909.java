package review;

import java.util.ArrayDeque;
import java.util.Deque;

public class pro12909 {
    boolean solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (!deque.isEmpty() && deque.peekLast() == '(') {
                    deque.pollLast();
                    continue;
                }
            }

            deque.addLast(c);
        }
        return deque.size() == 0;
    }
}
