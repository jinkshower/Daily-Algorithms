package javaCourse.j5;

import java.util.Scanner;
import java.util.Stack;

public class j5to5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        Stack<Character> stack = new Stack<>();
        int answer = 0;
        char prev = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (str.charAt(i - 1) == '(') {
                    answer += stack.size();
                } else {
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // int m = sc.nextInt();

        Stack<Character> stack = new Stack<>();

        char prev = '(';
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ')' && prev == '(') {
                stack.pop();
                cnt += stack.size();
            } else if (c == ')' && prev == ')') {
                stack.pop();
                cnt += 1;
            } else {
                stack.push(c);
            }
            prev = c;
        }
        System.out.println(cnt);
    }
}
