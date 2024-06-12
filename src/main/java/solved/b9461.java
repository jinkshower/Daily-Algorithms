package solved;

import java.util.Scanner;

public class b9461 {

    static long[] d = new long[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        d[1] = 1;
        d[2] = 1;
        d[3] = 1;
        d[4] = 2;
        d[5] = 2;
        for (int i = 6; i <= 100; i++) {
            d[i] = d[i - 1] + d[i - 5];
        }

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            System.out.println(d[n]);
        }
    }
}
