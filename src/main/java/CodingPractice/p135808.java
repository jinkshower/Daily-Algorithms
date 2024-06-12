package CodingPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class p135808 {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> integers = Arrays.stream(score)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        Queue<Integer> queue = new LinkedList<>(integers);

        int boxCount = score.length / m;
        for (int i = 0; i < boxCount; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.println(queue.peek());
                if (j == m) {
                    answer += queue.poll();
                } else {
                    queue.poll();
                }
            }
        }
        return answer * m;
    }
}
