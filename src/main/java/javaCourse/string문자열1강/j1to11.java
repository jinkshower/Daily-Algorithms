package javaCourse.string문자열1강;

import java.util.Scanner;

public class j1to11 {

    //강의 풀이
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        str = str + " ";
        int cnt = 1;
        String answer = "";
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                cnt++;
            } else {
                answer += str.charAt(i);
                if (cnt > 1) {
                    answer += String.valueOf(cnt);
                }
                cnt = 1;
            }
        }
        System.out.println(answer);
    }

    //내풀이
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        char prev = str.charAt(0);

        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur == prev) {
                cnt++;
            } else {
                String tmp = (cnt >= 2) ? prev + "" + cnt : prev + "";
                sb.append(tmp);
                cnt = 1;
                prev = cur;
            }
        }
        String tmp = (cnt >= 2) ? prev + "" + cnt : prev + "";
        sb.append(tmp);

        System.out.println(sb);
    }
}
