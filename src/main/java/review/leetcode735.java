package review;

import java.util.Stack;

public class leetcode735 {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) { //O(n)
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
                continue;
            } else {
                boolean noRemain = false;
                int remain = asteroids[i];
                while (!stack.isEmpty() && isCollidable(stack.peek(), remain)) { //O(n)
                    int top = stack.pop();
                    if (Math.abs(top) == Math.abs(remain)) {
                        noRemain = true;
                        break; // no remain
                    }
                    remain = Math.abs(top) > Math.abs(remain) ? top : remain;
                }
                if (!noRemain) {
                    stack.push(remain);
                }
            }
        }

        int[] result = new int[stack.size()];
        int idx = 0;
        for (int i : stack) {
            result[idx++] = i;
        }
        return result;
    }

    private boolean isCollidable(int a, int b) {
        if ((a > 0 && b < 0)) {
            return true;
        }
        return false;
    }
}
