package solved;

import java.util.Scanner;

public class b1436 {

    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int count = 0;
        int start = 665;
        while (count != n) {
            start++;
            String str = String.valueOf(start);
            if (str.contains("666")) {
                count++;
            }
        }
        System.out.println(start);
    }
}
