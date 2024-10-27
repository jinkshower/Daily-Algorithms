package datastructure.self;

import java.util.HashMap;
import java.util.Map;

public class NoDuplicate {

    public boolean isAllUnique(String input) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : input.toCharArray()) {
            if (map.containsKey(c)) {
                return false;
            }
            map.put(c, 1);
        }
        return true;
    }
}
