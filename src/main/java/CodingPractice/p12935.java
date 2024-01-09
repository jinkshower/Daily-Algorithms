package CodingPractice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p12935 {
    public int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        int[] answer = new int[arr.length - 1];
        int min = arr[0];
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        List<Integer> integers = Arrays.stream(arr).boxed().collect(Collectors.toList());
        integers.remove(minIndex);
        return integers.stream().mapToInt(i -> i).toArray();
    }
}
