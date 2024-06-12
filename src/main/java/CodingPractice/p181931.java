package CodingPractice;

import java.util.ArrayList;
import java.util.List;

public class p181931 {
    public int solution(int a, int d, boolean[] included) {
        List<Integer> arithmeticSequence = new ArrayList<>();
        int answer = 0;
        for (int i = 0; i < included.length; i++) {
            arithmeticSequence.add(a + d * i);
        }
        for (int i = 0; i < included.length; i++) {
            if (included[i]) {
                answer += arithmeticSequence.get(i);
            }
        }
        return answer;
//        IntStream.range(0, included.length)
//                .map(idx -> included[idx] ? a + (idx * d) : 0)
//                .sum();
    }
}
