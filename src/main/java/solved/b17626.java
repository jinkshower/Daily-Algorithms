package solved;

import java.util.Scanner;

public class b17626 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        int[] d = new int[n + 1];
        d[0] = 0;
        d[1] = 1;

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1];
            for (int j = 1; j * j <= i; j++) {
                d[i] = Math.min(d[i], d[i - j * j]);
            }
            d[i] += 1;
        }
        System.out.println(d[n]);
    }

    //다시풀기
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] d = new int[n + 1];
        d[0] = 0;
        d[1] = 1;

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1];
            for (int j = 2; j * j <= i; j++) {
                d[i] = Math.min(d[i - j * j], d[i]);
            }
            d[i] += 1;
        }
        System.out.println(d[n]);
    }
}
