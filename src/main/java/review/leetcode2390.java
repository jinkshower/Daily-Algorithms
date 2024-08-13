package review;

import java.util.Stack;

public class leetcode2390 {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        char[] result = new char[stack.size()];
        int index = 0;
        for (char c : stack) {
            result[index++] = c;
        }
        return new String(result);
    }
}
