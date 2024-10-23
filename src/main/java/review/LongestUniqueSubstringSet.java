package review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestUniqueSubstringSet {
    public static void main(String[] args) {
        String s = "abcbedfed";
        List<String> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        int curMax = map.get(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (curMax < i) {
                result.add(sb.toString());
                sb = new StringBuilder();

                curMax = map.get(c);
            } else {
                curMax = Math.max(curMax, map.get(c));
            }
            sb.append(c);
        }
        result.add(sb.toString());

        System.out.println(result);
    }
}
