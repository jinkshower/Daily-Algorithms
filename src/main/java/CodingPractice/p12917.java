package CodingPractice;

import java.util.Arrays;
import java.util.Collections;

public class p12917 {
    public String solution(String s) {
        String[] strings = s.split("");
        Arrays.sort(strings, Collections.reverseOrder());
        return String.join("", strings);
    }
}
