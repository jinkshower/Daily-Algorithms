package CodingPractice;

import java.util.Stack;

public class p133502 {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i : ingredient) {
            stack.push(i);
            if (stack.size() >= 4) {
                int size = stack.size();
                if (stack.get(size - 1) == 1
                        && stack.get(size - 2) == 2
                        && stack.get(size - 3) == 3
                        && stack.get(size - 4) == 1) {
                    answer++;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }
            }
        }

        return answer;
    }
}
