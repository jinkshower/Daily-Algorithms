package javaCourse;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class j4to4 {

    static boolean isAna(Map<Character, Integer> map, String str2) {
        for (char c : str2.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String str2 = sc.next();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str2.length() - 1; i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int lt = 0;
        int count = 0;
        for (int rt = str2.length() - 1; rt < str.length(); rt++) {
            char c = str.charAt(rt);
            map.put(c, map.getOrDefault(c, 0) + 1);

            if (isAna(new HashMap<>(map), str2)) {
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
