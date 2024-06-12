package solved;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class b1620 {

    public static int n, m; //n 포켓몬 개수 m 문제 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        Map<Integer, String> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String str = sc.nextLine();
            map.put(i, str);
            map2.put(str, i);
        }

        for (int i = 0; i < m; i++) {
            String str = sc.next();
            try {
                int idx = Integer.parseInt(str);
                System.out.println(map.get(idx));
            } catch (NumberFormatException e) {
                System.out.println(map2.get(str));
            }
        }
    }
}
