package CodingPractice;

import java.util.*;
import java.util.stream.Collectors;

public class p131128 {
    public String solution(String X, String Y) {
        Map<String, Integer> xMap = new HashMap<>();
        Map<String, Integer> yMap = new HashMap<>();

        List<String> list = new ArrayList<>();

        for (String key : X.split("")) {
            xMap.put(key, xMap.getOrDefault(key, 0) + 1);
        }
        for (String key : Y.split("")) {
            yMap.put(key, yMap.getOrDefault(key, 0) + 1);
        }
        for (String xKey : xMap.keySet()) {
            for (String yKey : yMap.keySet()) {
                if (xKey.equals(yKey)) {
                    int maxCommon = Math.min(xMap.get(xKey), yMap.get(yKey));
                    for (int i = 0; i < maxCommon; i++) {
                        list.add(xKey);
                    }
                }
            }
        }

        String answer = list.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining());
        return answer.isEmpty() ? "-1" : answer;
    }
}
