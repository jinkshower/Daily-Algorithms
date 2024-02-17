package ndb;

import java.util.Scanner;

public class CardGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N, M 공백을 기준으로 구분하여 입력 받기
        int n = sc.nextInt();
        int m = sc.nextInt();

        int max = 0;
        for (int i = 0; i < n; i++) {
            int min_value = 10001;
            for (int j = 0; j < m; j++) {
                int data = sc.nextInt();
                min_value = Math.min(min_value, data);
            }
            max = Math.max(max, min_value);
        }
        System.out.println(max);
    }

    //다시 풀기
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int max = 0;
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                int current = sc.nextInt();
                min = Math.min(min, current);
            }
            max = Math.max(min, max);
        }

        System.out.println(max);
    }
}
