package javaCourse.string문자열1강;

import java.util.Scanner;

public class j1to9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int answer = 0;
        for (char x : str.toCharArray()) {
            if (x >= 48 && x <= 57) {
                answer = answer * 10 + (x - 48);
            }
        }
        //다른 풀이임
        String k = "";
        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                k += x;
            }
        }
        System.out.println(answer);
    }
}
