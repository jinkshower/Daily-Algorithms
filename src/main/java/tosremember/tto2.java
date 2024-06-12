package tosremember;

import java.util.Scanner;

public class tto2 {

    //멋쟁이 숫자
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int len = s.length();
        int biggest = -1;
        for (int i = 0; i < len - 2; i++) {
            char cur = s.charAt(i);
            if (cur == s.charAt(i + 1) && cur == s.charAt(i + 2)) {
                biggest = Math.max(biggest, Integer.parseInt(s.substring(i, i + 3)));
            }
        }
        System.out.println(biggest);
    }
}
