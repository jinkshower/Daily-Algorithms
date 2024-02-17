package ndb;

import java.util.Scanner;

//다시 풀기
public class MakeOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] d = new int[n + 1];
        d[1] = 0;

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1];
            if (i % 2 == 0) {
                d[i] = Math.min(d[i], d[i / 2]);
            }
            if (i % 3 == 0) {
                d[i] = Math.min(d[i], d[i / 3]);
            }
            if (i % 5 == 0) {
                d[i] = Math.min(d[i], d[i / 5]);
            }
            d[i] += 1;
        }

        System.out.println(d[n]);
    }
}
