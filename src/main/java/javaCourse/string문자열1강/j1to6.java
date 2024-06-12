package javaCourse.string문자열1강;

import java.util.Scanner;

public class j1to6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.indexOf(c) == i) {
                answer += c;
            }
        }
        System.out.println(answer);
    }
}
