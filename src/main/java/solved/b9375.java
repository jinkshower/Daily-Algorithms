package solved;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class b9375 {

    static Scanner sc = new Scanner(System.in);

    private static void solve() {
        int n = sc.nextInt();
        sc.nextLine();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] split = str.split(" ");
            int count = map.getOrDefault(split[1], 0);
            map.put(split[1], count + 1);
        }

        int sum = 1;
        for (int val : map.values()) {
            sum *= (val + 1);
        }

        System.out.println(sum - 1);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }
}
