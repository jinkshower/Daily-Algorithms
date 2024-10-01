package review;

import java.util.ArrayList;
import java.util.List;

public class pro42840 {
    public int[] solution(int[] answers) {
        int[] a = new int[]{1, 2, 3, 4, 5}; // 5
        int[] b = new int[]{2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] c = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10

        int topC = 0;
        int aC = 0;
        int bC = 0;
        int cC = 0;
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (a[i % 5] == answer) {
                aC++;
            }
            if (b[i % 8] == answer) {
                bC++;
            }
            if (c[i % 10] == answer) {
                cC++;
            }
            topC = Math.max(topC, Math.max(aC, Math.max(bC, cC)));
        }
        List<Integer> tops = new ArrayList<>();
        if (aC == topC) {
            tops.add(1);
        }
        if (bC == topC) {
            tops.add(2);
        }
        if (cC == topC) {
            tops.add(3);
        }

        return tops.stream().mapToInt(i -> i).toArray();
    }
}
