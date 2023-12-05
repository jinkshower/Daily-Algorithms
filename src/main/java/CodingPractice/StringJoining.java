package CodingPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class StringJoining {
    public static void main(String[] args) {
        List<String> upperBridge = new ArrayList<>();
        List<String> lowerBridge = new ArrayList<>();
        upperBridge.add(" O ");
        upperBridge.add(" X ");
        lowerBridge.add("   ");
        String joined = joinString(upperBridge);
        String lowerJoined = joinString(lowerBridge);
        System.out.println(joined);
    }

    private static String joinString(List<String> upperBridge) {
        StringJoiner stringJoiner = new StringJoiner("|", "[", "]\n");
        for (String string : upperBridge) {
            stringJoiner.add(string);
        }
        return stringJoiner.toString();
    }
}
