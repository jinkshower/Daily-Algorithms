package ndb;

import java.util.Scanner;

public class LuckyStrike {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int length = str.length();

        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < length; i++) {
            if (i < length / 2) {
                leftSum += str.charAt(i) - '0';
            } else {
                rightSum += str.charAt(i) - '0';
            }
        }

        String result = leftSum == rightSum ? "LUCKY" : "READY";
        System.out.println(result);
    }
}
