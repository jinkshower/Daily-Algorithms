package review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode1657 {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < word1.length(); i++) {
            map1.put(word1.charAt(i), map1.getOrDefault(word1.charAt(i), 0) + 1);
            map2.put(word2.charAt(i), map2.getOrDefault(word2.charAt(i), 0) + 1);
        }

        // Set<Character> map1Key = map1.keySet();
        // Set<Character> map2Key = map2.keySet();
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }

        List<Integer> map1Values = new ArrayList<>(map1.values());
        List<Integer> map2Values = new ArrayList<>(map2.values());
        Collections.sort(map1Values);
        Collections.sort(map2Values);
        if (!map1Values.equals(map2Values)) {
            return false;
        }
        return true;
    }
}
