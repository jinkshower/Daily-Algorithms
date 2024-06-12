package javaCourse.string문자열1강;

import java.util.Scanner;

public class j1to5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        String answer = "";

        char[] arr = str.toCharArray();

        int lt = 0;
        int rt = str.length() - 1;
        while (lt < rt) {
            if (!Character.isLetter(arr[lt])) {
                lt++;
            } else if (!Character.isLetter(arr[rt])) {
                rt--;
            } else {
                char tmp = arr[lt];
                arr[lt] = arr[rt];
                arr[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(arr);
        System.out.println(answer);
    }
}
