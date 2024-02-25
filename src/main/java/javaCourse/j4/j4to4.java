package javaCourse.j4;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class j4to4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String str2 = sc.next();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str2.length() - 1; i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : str2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        int lt = 0;
        int count = 0;
        for (int rt = str2.length() - 1; rt < str.length(); rt++) {
            char c = str.charAt(rt);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (map.equals(map2)) {
                count++;
            }

            char k = str.charAt(lt);
            map.put(k, map.get(k) - 1);
            if (map.get(k) == 0) {
                map.remove(k);
            }
            lt++;
        }
        System.out.println(count);
    }
}
