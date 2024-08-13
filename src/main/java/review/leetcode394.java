package review;

import java.util.Stack;

public class leetcode394 {

    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<StringBuilder> sbStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for (char c : s.toCharArray()) {
            //숫자라면 cnt를 갱신한다.
            if (Character.isDigit(c)) {
                cnt = (cnt * 10) + (c - '0');
            } else if (c == '[') {
                //숫자를 저장한다.
                intStack.push(cnt);
                cnt = 0;
                //현재까지의 sb에 append된 값을 저장한다.
                //숫자 연산은 ]가 나올때 하므로
                sbStack.push(sb);
                //sb는 새롭게 해야함 stack에 저장했으므로
                sb = new StringBuilder();
            } else if (c == ']') {
                //가장 위에 있는 반복할 숫자를 찾아옴
                int repeat = intStack.pop();
                //현재 값을 tmp에 임시저장
                StringBuilder tmp = sb;
                //반복한 것을 달아줄 sb에서 가져옴
                //가장 처음에 [를 넣을 때 empty한 StringBuilder를 넣었으니
                //pop할 수 있는 개수가 1개 낭음.
                sb = sbStack.pop();
                while (cnt-- > 0) {
                    sb.append(tmp);
                }

            } else {
                //알파벳은 그냥 append
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
