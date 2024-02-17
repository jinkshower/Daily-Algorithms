package ndb;

import java.util.Scanner;

public class Time3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    sb.append(i).append(j).append(k);
                    if (sb.indexOf("3") >= 0) {
                        count++;
                    }
                    sb = new StringBuilder();
                }
            }
        }
        System.out.println(count);
    }
}
