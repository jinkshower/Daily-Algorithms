package javaCourse2.datastructure3강;

import java.util.Stack;

public class j3to2 {

    //강의 풀이
    public String solution(String s) {
        String answer = "";
        Stack<String> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x == ')') {
                String tmp = "";
                while (!stack.isEmpty()) {
                    String c = stack.pop();
                    if (c.equals("(")) {
                        String num = "";
                        while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                            num = stack.pop() + num;
                        }
                        String res = "";
                        int cnt = 0;
                        if (num.equals("")) {
                            cnt = 1;
                        } else {
                            cnt = Integer.parseInt(num);
                        }
                        for (int i = 0; i < cnt; i++) {
                            res += tmp;
                        }
                        stack.push(res);
                        break;
                    }
                    tmp = c + tmp;
                }
            } else {
                stack.push(String.valueOf(x));
            }
        }
        for (String x : stack) {
            answer += x;
        }
        return answer;
    }

    //다시 풀기
    public String solution(String s) {
        String answer = "";
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                String tmp = "";
                while (!stack.isEmpty()) {
                    String o = stack.pop();
                    if (o.equals("(")) {
                        String num = "";
                        while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                            num = stack.pop() + num;
                        }
                        String res = "";
                        int cnt = 0;
                        if (num.equals("")) {
                            cnt = 1;
                        } else {
                            cnt = Integer.parseInt(num);
                        }
                        for (int i = 0; i < cnt; i++) {
                            res += tmp;
                        }
                        stack.push(res);
                        break;
                    }
                    tmp = o + tmp;
                }
            } else {
                stack.push(String.valueOf(c));
            }
        }
        for (String g : stack) {
            answer += g;
        }
        return answer;
    }
}
