package CodingPractice;

import java.util.stream.IntStream;

public class p120831 {
    public int solution(int n) {
        return IntStream.rangeClosed(0, n).filter(i -> i % 2 == 0).sum();
    }
}
