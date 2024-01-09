package CodingPractice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class p86051 {

    public int solution(int[] numbers) {
        List<Integer> cache = IntStream.rangeClosed(0, 9).boxed().collect(Collectors.toList());
        for (int i : numbers) {
            cache.remove((Integer) i);
        }
        return cache.stream().mapToInt(i -> i).sum();
    }
}
