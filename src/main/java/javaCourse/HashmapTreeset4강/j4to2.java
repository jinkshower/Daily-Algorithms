package javaCourse.HashmapTreeset4강;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class j4to2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String str2 = sc.next();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        boolean isR = true;
        for (char c : str2.toCharArray()) {
            if (map.containsKey(c)) {
                int count = map.get(c);
                if (count == 1) {
                    map.remove(c);
                } else {
                    map.put(c, count - 1);
                }
            } else {
                isR = false;
                break;
            }
        }
        if (map.size() > 0) {
            isR = false;
        }
        String answer = isR ? "YES" : "NO";
        System.out.println(answer);
    }
}
