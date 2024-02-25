package javaCourse.string문자열1강;

import java.util.Scanner;

public class j1to12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        String[] arr = new String[n];
        int pos = 7;
        for (int i = 0; i < n; i++) {
            String tmp = str.substring(pos - 7, pos);
            arr[i] = tmp;
            pos += 7;
        }

        String answer = "";
        for (String s : arr) {
            String tmp = "";
            for (char c : s.toCharArray()) {
                tmp += c == '#' ? 1 : 0;
            }
            int itmp = Integer.parseInt(tmp, 2);
            answer += (char) itmp;
        }
        System.out.println(answer);
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();

        String answer = "";
        for (int i = 0; i < n; i++) {
            String tmp = str.substring(0, 7).replace("#", "1").replace("*", "0");
            int num = Integer.parseInt(tmp, 2);
            answer += (char) num;
            str = str.substring(7);
        }

        System.out.println(answer);
    }
}
