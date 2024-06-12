package CodingPractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class p76502 {
    public int solution(String s) {
        int answer = 0;
        //s가 올바른 문자열인지 확인

        //회전 -> 확인
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            String rotation = sb.substring(0, i);
            sb.delete(0, i);
            sb.append(rotation);

            if (isRight(sb.toString())) {
                answer++;
            }
        }


        return answer;
    }

    public boolean isRight(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('(', -1);
        map.put(')', 1);
        map.put('[', -2);
        map.put(']', 2);
        map.put('{', -3);
        map.put('}', 3);

        Stack<Integer> charStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            int token = map.get(tmp);

            if (token < 0) {
                charStack.push(token);
            } else {
                if (charStack.isEmpty()) {
                    return false;
                }
                int peek = charStack.peek();
                if ((peek + token) == 0) {
                    charStack.pop();
                } else {
                    charStack.push(token);
                }
            }
        }
        return charStack.isEmpty();
    }
}
