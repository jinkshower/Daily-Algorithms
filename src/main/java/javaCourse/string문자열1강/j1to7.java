package javaCourse.string문자열1강;

import java.util.Scanner;

public class j1to7 {

    //강의 풀이
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase();
        int len = str.length();

        String answer = "YES";
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                answer = "NO";
                break;
            }
        }
        System.out.println(answer);
    }

    //equalsIgnoreCase
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String tmp = new StringBuilder(str).reverse().toString();
        String answer = "NO";
        if (str.equalsIgnoreCase(tmp)) {
            answer = "YES";
        }
        System.out.println(answer);
    }
}
