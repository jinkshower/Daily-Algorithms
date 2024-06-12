package solved;

import java.util.Scanner;

public class b2579 {

    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        if (n == 1) {
            System.out.println(arr[1]);
            return;
        }
        int[] d = new int[n + 1];
        d[1] = arr[1];
        d[2] = arr[1] + arr[2];

        for (int i = 3; i <= n; i++) {
            d[i] = Math.max(d[i - 2], d[i - 3] + arr[i - 1]) + arr[i];
        }
        System.out.println(d[n]);
    }
}
