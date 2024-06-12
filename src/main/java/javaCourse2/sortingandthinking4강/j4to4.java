package javaCourse2.sortingandthinking4강;

import java.util.Arrays;

public class j4to4 {

    public int solution(int[] score, int k) {
        int answer = 0;
        Arrays.sort(score);
        for (int i = 0; i <= score.length - k; i++) {
            if (score[i + k - 1] - score[i] <= 10) {
                for (int j = i; j <= i + k - 1; j++) {
                    answer += score[j];
                }
                break;
            }
        }

        answer = (int) Math.floor(answer / k);
        return answer;
    }
}
