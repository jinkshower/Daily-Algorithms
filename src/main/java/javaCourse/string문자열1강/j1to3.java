package javaCourse.string문자열1강;

import java.util.Scanner;

public class j1to3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(" ");

        StringBuilder sb = new StringBuilder();

        int max = 0;
        String answer = "";
        for (String s : split) {
            if (s.length() > max) {
                max = s.length();
                answer = s;
            }
        }
        System.out.println(answer);
    }

    //indexOf, substring으로 풀기
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        StringBuilder sb = new StringBuilder();

        int max = Integer.MIN_VALUE;
        String answer = "";
        int pos = 0;
        while ((pos = str.indexOf(' ')) != -1) {
            String tmp = str.substring(0, pos);
            if (tmp.length() > max) {
                max = tmp.length();
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }
        if (str.length() > max) {
            answer = str;
        }
        System.out.println(answer);
    }
}
