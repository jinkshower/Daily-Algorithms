package solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class b11399 {

    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);
        int[] d = new int[n];
        d[0] = list.get(0);
        int sum = d[0];
        for (int i = 1; i < n; i++) {
            d[i] = d[i - 1] + list.get(i);
            sum += d[i];
        }
        System.out.println(sum);
    }
}
