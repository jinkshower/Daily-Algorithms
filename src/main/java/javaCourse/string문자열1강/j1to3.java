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
}
