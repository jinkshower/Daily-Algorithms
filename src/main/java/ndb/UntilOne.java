package ndb;

import java.util.Scanner;

public class UntilOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int count = 0;

        while (true) {
            int target = (n / k) * k;
            count += n - target;

            if (n < k) break;
            count++;
            n /= k;
        }
        count += (n - 1);
        System.out.println(count);
    }
}
