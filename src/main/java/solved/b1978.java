package solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class b1978 {

    public static int n;
    public static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        boolean[] isPrime = new boolean[1001];
        Arrays.fill(isPrime, true);

        isPrime[1] = false;

        for (int i = 2; i * i <= 1001; i++) {

            if (!isPrime[i]) {
                continue;
            }
            for (int j = i * i; j < 1001; j += i) {
                isPrime[j] = false;
            }
        }

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int count = 0;
        for (Integer num : list) {
            if (isPrime[num]) {
                count++;
            }
        }
        System.out.println(count);
    }
}
