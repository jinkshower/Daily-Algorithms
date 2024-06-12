package CodingPractice;

import java.util.ArrayList;
import java.util.List;

public class p181927 {
    public int[] solution(int[] num_list) {
        List<Integer> intList = new ArrayList<>();
        for (int element : num_list) {
            intList.add(element);
        }
        Integer lastElement = intList.get(intList.size() - 1);
        Integer secondToLastElement = intList.get(intList.size() - 2);
        if (lastElement > secondToLastElement) {
            intList.add(lastElement - secondToLastElement);
        } else {
            intList.add(lastElement * 2);
        }
        int[] answer = new int[num_list.length + 1];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = intList.get(i);
        }
        return answer;
    }
}
