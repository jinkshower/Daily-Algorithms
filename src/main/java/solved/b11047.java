package solved;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class b11047 {

    static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        List<Integer> coins = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coins.add(sc.nextInt());
        }

        int index = n - 1;
        int count = 0;
        while (k >= 0) {
            int current = coins.get(index);
            index -= 1;
            if (k >= current) {
                int curCount = k / current;
                k -= current * curCount;
                count += curCount;
            }
            if (index < 0) {
                break;
            }
        }
        System.out.println(count);
    }
}
