package review;

import java.util.HashSet;
import java.util.Set;

public class pro42839 {
    static Set<Integer> set;

    public int solution(String numbers) {
        int answer = 0;

        set = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];

        recur(0, numbers, "", visited);

        int cnt = 0;
        for (int s : set) {
            if (isPrime(s)) {
                cnt++;
            }
        }
        return cnt;
    }

    private void recur(int depth, String numbers, String output, boolean[] visited) {
        if (depth == numbers.length()) {
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(output + numbers.charAt(i)));
                recur(depth + 1, numbers, output + numbers.charAt(i), visited);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
