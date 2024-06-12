package CodingPractice;

import java.util.*;

public class p138476 {

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int j : tangerine) {
            countMap.put(j, countMap.getOrDefault(countMap.get(j), 0) + 1);
        }

        List<Integer> sameNums = new ArrayList<>(countMap.values());
        sameNums.sort(Comparator.reverseOrder());

        for (Integer t : sameNums) {
            if (k <= 0) {
                break;
            }

            answer++;
            k -= t;
        }

        return answer;
    }
}
