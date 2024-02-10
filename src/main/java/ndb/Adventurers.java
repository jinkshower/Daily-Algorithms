package ndb;

import java.util.Arrays;
import java.util.Scanner;

public class Adventurers {

    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int count = 0;
        int answer = 0;

        for (int i = 0; i < n - 1; i++) {
            count++;
            if (count >= arr[i]) {
                answer++;
                count = 0;
            }
        }
        System.out.println(answer);
    }
}
