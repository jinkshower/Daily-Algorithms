package CodingPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p12939 {
    public String solution(String s) {
        String answer = "";
        String[] split = s.split(" ");
        List<Integer> intList = new ArrayList<>();
        for (String string : split) {
            intList.add(Integer.parseInt(string));
        }
        System.out.println(intList);
        int max = Collections.max(intList);
        int min = Collections.min(intList);
        StringBuilder sb = new StringBuilder();
        sb.append(min).append(" ").append(max);
        return sb.toString();
    }
}
