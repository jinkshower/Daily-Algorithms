package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class p2248 {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        String str = my_string.substring(0, s);
        String overStr = my_string.substring(s + overwrite_string.length());
        answer = str + overwrite_string + overStr;
        return answer;
    }
}
