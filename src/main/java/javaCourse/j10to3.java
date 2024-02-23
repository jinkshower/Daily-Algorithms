package javaCourse;

import java.util.Scanner;

public class j10to3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] d = new int[n];
        d[0] = 1;

        int answer = 0;
        for (int i = 1; i < n; i++) {
            int tmp = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    tmp = Math.max(d[j], tmp);
                }
            }
            d[i] = tmp + 1;
            answer = Math.max(d[i], answer);
        }
        System.out.println(answer);
    }
}
