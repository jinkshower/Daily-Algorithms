package solved;

import java.util.Scanner;

public class b1929 {

    public static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = n; i <= m; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isPrime(int num) {
        int count = 0;
        for (int i = 1; i < (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                count++;
            }
        }
        System.out.println(count);
        return count == 1;
    }
}
