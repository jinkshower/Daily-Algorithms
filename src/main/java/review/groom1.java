package review;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class groom1 {
    public static void main(String[] args) {
        String input = "abdaccadd";
        int[] diversities = new int[27];
        for (int i = 1; i <= 26; i++) {
            Map<Character, Integer> cache = new HashMap<>();
            int l = 0;
            int r = 0;
            int max = -1;
            while (r < input.length()) {
                char cur = input.charAt(r);
                cache.put(cur, cache.getOrDefault(cur, 0) + 1);

                while (cache.size() > i) {
                    char left = input.charAt(l);
                    cache.put(left, cache.get(left) - 1);
                    if (cache.get(left) == 0) {
                        cache.remove(left);
                    }
                    l++;
                }
                max = Math.max(max, r - l + 1);
                r++;
            }

            diversities[i] = (max == -1) ? 0 : max;
        }

        System.out.println(Arrays.toString(diversities));
    }
}
