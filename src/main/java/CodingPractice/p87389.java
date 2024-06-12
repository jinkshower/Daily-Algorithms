package CodingPractice;

import java.util.ArrayList;
import java.util.List;

public class p87389 {
    public int solution(int n) {
        List<Integer> intlist = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 1) {
                intlist.add(i);
            }
        }
        return intlist.stream().min(Integer::compare).orElse(0);
    }
}
