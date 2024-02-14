package solved;

import java.util.Scanner;

public class b9095 {

    public static int t;
    public static int n;
    public static Scanner sc = new Scanner(System.in);

    public static void solve() {
        n = sc.nextInt();
        int[] d = new int[11];

        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for (int i = 4; i <= n; i++) {
            d[i] = d[i - 1] + d[i - 2] + d[i - 3];
        }
        System.out.println(d[n]);
    }


    public static void main(String[] args) {
        t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            solve();
        }
    }
}
