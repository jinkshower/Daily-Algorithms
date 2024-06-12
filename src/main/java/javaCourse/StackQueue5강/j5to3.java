package javaCourse.StackQueue5강;

import java.util.Stack;

public class j5to3 {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            int idx = move - 1;
            int top = -1;
            //해당 위치에 가장 높은 인형찾기
            for (int j = 0; j < board.length; j++) {
                if (board[j][idx] != 0) {
                    top = board[j][idx];
                    board[j][idx] = 0;
                    break;
                }
            }
            if (top == -1) {
                break;
            }
            if (!stack.isEmpty()) {
                int stackTop = stack.peek();
                if (top == stackTop) {
                    answer += 2;
                    stack.pop();
                } else {
                    stack.push(top);
                }
            } else {
                stack.push(top);
            }
        }
        return answer;
    }
}
