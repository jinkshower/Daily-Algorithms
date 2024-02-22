package javaCourse;

import java.util.Scanner;

public class j2to4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int lt = 0;

        int cnt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) {
                cnt++;
            }
            while (sum >= m) {
                sum -= arr[lt++];
                if (sum == m) {
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
