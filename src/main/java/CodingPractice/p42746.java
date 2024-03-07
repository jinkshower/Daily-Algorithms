package CodingPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p42746 {

    public String solution(int[] numbers) {
        String answer = "";
        // String[] arr = new String[numbers.length];
        // for (int i = 0; i < numbers.length; i++) {
        //     arr[i] = String.valueOf(numbers[i]);
        // }

        // Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        List<String> arr = new ArrayList<>();
        for (int x : numbers) {
            arr.add(String.valueOf(x));
        }

        Collections.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        answer = sb.toString();
        if (answer.charAt(0) == '0') {
            return "0";
        }
        return answer;
    }
}
