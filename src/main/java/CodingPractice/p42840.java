package CodingPractice;

import java.util.ArrayList;
import java.util.List;

public class p42840 {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5}; //5
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5}; //8
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; //10

        int oneCount = 0;
        int twoCount = 0;
        int threeCount = 0;
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % one.length]) {
                oneCount++;
            }
            if (answers[i] == two[i % two.length]) {
                twoCount++;
            }
            if (answers[i] == three[i % three.length]) {
                threeCount++;
            }
        }

        List<Integer> result = new ArrayList<>();
        int topCount = Math.max(oneCount, Math.max(twoCount, threeCount));

        if (topCount == oneCount) {
            result.add(1);
        }
        if (topCount == twoCount) {
            result.add(2);
        }
        if (topCount == threeCount) {
            result.add(3);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

}
