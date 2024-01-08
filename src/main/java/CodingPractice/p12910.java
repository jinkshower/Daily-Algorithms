package CodingPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class p12910 {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> elements = new ArrayList<>();
        for (int i : arr) {
            if (i % divisor == 0) {
                elements.add(i);
            }
        }
        if (elements.isEmpty()) {
            elements.add(-1);
        }
        elements.sort(Comparator.naturalOrder());

        return elements.stream().mapToInt(i -> i).toArray();
    }
}
