package review;

import java.util.HashSet;
import java.util.Set;

public class programmers42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> set = new HashSet<>();

        for (String p : phone_book) {
            set.add(p);
        }

        for (String p : phone_book) {
            for (int i = 0; i < p.length(); i++) {
                if (set.contains(p.substring(0, i))) {
                    return false;
                }
            }
        }
        return answer;
    }
}
