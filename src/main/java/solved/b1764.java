package solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class b1764 {

    public static int n, m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            map.put(str, str);
        }

        List<String> sum = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            String str = sc.nextLine();
            String found = map.getOrDefault(str, "");
            if (found.equals("")) {
                continue;
            } else {
                count++;
                sum.add(found);
            }
        }
        Collections.sort(sum);
        System.out.println(count);
        for (String str : sum) {
            System.out.println(str);
        }
    }
}
