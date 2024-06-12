package CodingPractice;

import java.util.ArrayList;
import java.util.List;

public class p12940 {

    public int[] solution(int n, int m) {
        int bigger = Math.max(n, m);
        List<Integer> divisors = new ArrayList<>();
        int a = 0;
        int b = 0;
        for (int i = 1; i <= bigger; i++) {
            if (n % i == 0 && m % i == 0) {
                divisors.add(i);
            }
        }
        a = divisors.stream().mapToInt(Integer::intValue).max().orElse(1);
        b = n * m / a;
        return new int[]{a, b};
    }
}
