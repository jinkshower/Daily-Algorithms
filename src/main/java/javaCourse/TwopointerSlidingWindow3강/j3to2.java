package javaCourse.TwopointerSlidingWindow3강;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class j3to2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arrA = new int[n];

        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arrB = new int[m];

        for (int i = 0; i < m; i++) {
            arrB[i] = sc.nextInt();
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB);
        List<Integer> answer = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < m) {
            if (arrA[p1] < arrB[p2]) {
                p1++;
            } else if (arrA[p1] > arrB[p2]) {
                p2++;
            } else {
                answer.add(arrA[p1++]);
                p2++;
            }
        }

        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}
