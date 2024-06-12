package javaCourse2.sortingandthinking4강;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class j4to3 {

    public int solution(int[] nums, int k) {
        int answer = 0;
        Integer[] tmp = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, (a, b) -> b - a);
        int sum = 0;
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < nums.length / 2; i++) {
            sum += tmp[i * 2 + 1];
            diff.add(tmp[i * 2] - tmp[i * 2 + 1]);
        }
        Collections.sort(diff, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            sum += diff.get(i);
        }
        return sum;
    }
}
