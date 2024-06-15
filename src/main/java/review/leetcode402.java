package review;

import java.util.Stack;

public class leetcode402 {

    class Solution {

        public String removeKdigits(String num, int k) {
            //계산할 필요가 없음
            if (num.length() == k) {
                return "0";
            }

            Stack<Character> stack = new Stack<>();
            for (char c : num.toCharArray()) {
                while (!stack.isEmpty()) {
                    //앞 자리수가 현재 자리보다 크고 k가 남아있다면
                    if (stack.peek() > c && k > 0) {
                        stack.pop();
                        k--;
                    } else {
                        break;
                    }
                }
                stack.push(c);
            }

            //오름차순으로 있어 k가 남아있을때.
            while (k != 0) {
                stack.pop();
                k--;
            }

            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }

            String answer = sb.toString();
            while (answer.length() != 1 && answer.startsWith("0")) {
                answer = answer.substring(1);
            }

            return answer;
        }
    }
}
