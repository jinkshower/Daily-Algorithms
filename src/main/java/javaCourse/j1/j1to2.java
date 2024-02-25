package javaCourse.j1;

import java.util.Scanner;

public class j1to2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c >= 97 && c <= 122) {
                sb.append((char) (c - 32));
            } else {
                sb.append((char) (c + 32));
            }
        }
        System.out.println(sb);
    }
}
