package CodingPractice;

import java.util.HashMap;
import java.util.Map;

public class p118666 {
    public String solution(String[] survey, int[] choices) {

        Map<Integer, Integer> score = new HashMap<>(
                Map.of(1, -3,
                        2, -2,
                        3, -1,
                        4, 0,
                        5, 1,
                        6, 2,
                        7, 3)
        );
        Map<String, Integer> person = new HashMap<>(
                Map.of("R", 0,
                        "T", 0,
                        "C", 0,
                        "F", 0,
                        "J", 0,
                        "M", 0,
                        "A", 0,
                        "N", 0)
        );
        for (int i = 0; i < choices.length; i++) {
            String problem = survey[i];
            int answer = score.get(choices[i]);

            if (answer < 0) {
                String s = problem.charAt(0) + "";
                int origin = person.get(s);
                person.put(s, origin - answer);
            } else if (answer > 0) {
                String s = problem.charAt(1) + "";
                int origin = person.get(s);
                person.put(s, origin + answer);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(person.get("R") >= person.get("T") ? "R" : "T");
        stringBuilder.append(person.get("C") >= person.get("F") ? "C" : "F");
        stringBuilder.append(person.get("J") >= person.get("M") ? "J" : "M");
        stringBuilder.append(person.get("A") >= person.get("N") ? "A" : "N");
        return stringBuilder.toString();
    }
}
