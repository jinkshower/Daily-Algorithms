package CodingPractice;

import java.util.HashMap;
import java.util.Map;

public class p81301 {
    public long solution(String s) {
        Map<String, String> num = new HashMap<>(
                Map.of("zero", "0",
                        "one", "1",
                        "two", "2",
                        "three", "3",
                        "four", "4",
                        "five", "5",
                        "six", "6",
                        "seven", "7",
                        "eight", "8",
                        "nine", "9"));
        for (String string : num.keySet()) {
            if (s.contains(string)) {
                s = s.replace(string, num.get(string));
            }
        }
        return Long.parseLong(s);
    }

    public static void main(String[] args) {
        p81301 p = new p81301();
        System.out.println(p.solution("one4seveneight"));
    }
}
