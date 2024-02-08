package ndb;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicSwap {

    public static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        Integer[] arrA = new Integer[n];
        Integer[] arrB = new Integer[n];

        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }
        for (int j = 0; j < n; j++) {
            arrB[j] = sc.nextInt();
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());
        int tmp = 0;

        for (int i = 0; i < k; i++) {

            if (arrA[i] < arrB[i]) {
                tmp = arrA[i];
                arrA[i] = arrB[i];
                arrB[i] = tmp;
            } else {
                break;
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += arrA[i];
        }
        System.out.println(answer);
    }
}
