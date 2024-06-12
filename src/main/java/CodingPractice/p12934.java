package CodingPractice;

import java.util.stream.LongStream;

public class p12934 {
    public long solution(long n) {
        long found = 0;
        found = LongStream.rangeClosed(0, n)
                .filter(i -> i * i == n)
                .findFirst()
                .orElse(-1);
        return found == -1 ? found : (found + 1) * (found + 1);
    }
}
