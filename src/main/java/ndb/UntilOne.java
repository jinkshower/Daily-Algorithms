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
            n = target;

            if (n < k) {
                break;
            }
            count++;
            n /= k;
        }
        count += (n - 1);
        System.out.println(count);
    }

    //다시 풀기
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int count = 0;
        while (n != 1) {
            if (n % k == 0) {
                n /= k;
            } else {
                n -= 1;
            }
            count++;
        }
        System.out.println(count);
    }
}
