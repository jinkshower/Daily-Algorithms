package javaCourse.string문자열1강;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class j1to4 {

    //StringBuilder reverse
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(sc.next());
            String tmp = sb.reverse().toString();
            result.append(tmp).append("\n");
        }

        System.out.println(result);
    }

    //직접 뒤집기
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        List<String> answer = new ArrayList<>();
        for (String s : arr) {
            char[] c = s.toCharArray();
            int lt = 0;
            int rt = s.length() - 1;
            while (lt < rt) {
                char tmp = c[lt];
                c[lt] = c[rt];
                c[rt] = tmp;
                lt++;
                rt--;
            }
            String tmp = String.valueOf(c);
            answer.add(tmp);
        }

    }
}
