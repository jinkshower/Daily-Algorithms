package CodingPractice;

import java.util.ArrayList;
import java.util.List;

public class p12930 {
    public String solution(String s) {

        List<String> list = new ArrayList<>(List.of(s.split(" ", -1)));
        List<String> modified = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();
        for (String string : list) {
            for (int i = 0; i < string.length(); i++) {
                char c = i % 2 == 0 ? Character.toUpperCase(string.charAt(i)) : Character.toLowerCase(string.charAt(i));
                tmp.append(c);
            }
            modified.add(tmp.toString());
            tmp = new StringBuilder();
        }
        return String.join(" ", modified);
    }
}
