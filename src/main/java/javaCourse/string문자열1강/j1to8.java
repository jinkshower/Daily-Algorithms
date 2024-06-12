package javaCourse.string문자열1강;

import java.util.Scanner;

public class j1to8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String answer = "NO";
        str = str.toUpperCase().replaceAll("[^A-Z]", ""); // A-Z가 아니면
        String tmp = new StringBuilder(str).reverse().toString();
        if (str.equals(tmp)) {
            answer = "YES";
        }
        System.out.println(answer);
    }
}
