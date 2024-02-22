package javaCourse;

import java.util.Scanner;

public class j2to6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int size = n / 2 + 1;
        // int m = sc.nextInt();

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i + 1;
        }

        int lt = 0;
        int sum = 0;

        int cnt = 0;
        for (int rt = 0; rt < size; rt++) {
            sum += arr[rt];
            if (sum == n) {
                cnt++;
            }
            if (sum > n) {
                while (sum >= n) {
                    sum -= arr[lt++];
                    if (sum == n) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
