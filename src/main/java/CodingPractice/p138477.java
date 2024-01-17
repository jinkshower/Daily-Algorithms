package CodingPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class p138477 {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> glory = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            glory.add(score[i]);
            glory.sort(Comparator.naturalOrder());
            if (glory.size() > k) {
                glory.remove(0);
            }
            answer[i] = glory.get(0);
        }
        return answer;
    }

    public static void main(String[] args) {
        p138477 prac = new p138477();
        System.out.println(Arrays.toString(prac.solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})));
    }
}
