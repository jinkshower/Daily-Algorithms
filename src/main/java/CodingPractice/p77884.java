package CodingPractice;

import java.util.List;
import java.util.stream.IntStream;

public class p77884 {
    public int solution(int left, int right) {
        List<Integer> num = IntStream.rangeClosed(left, right).boxed().toList();
        int sum = 0;
        for (int i : num) {
            int divisor = countDivisor(i);
            sum += divisor % 2 == 0 ? i : -i;
        }
        return sum;
    }

    public int countDivisor(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }
}
