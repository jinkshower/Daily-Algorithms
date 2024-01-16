package CodingPractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class p68644 {
    public int[] solution(int[] numbers) {
        Set<Integer> numberList = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                numberList.add(sum);
            }
        }
        int[] answer = new int[numberList.size()];
        int index = 0;
        for (Integer tmp : numberList) {
            answer[index] = tmp;
            index++;
        }
        Arrays.sort(answer);
        return answer;
    }
}
