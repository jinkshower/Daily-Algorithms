package CodingPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class p42839_2 {

    //소수찾기 다시풀기
    static boolean[] isPrime = new boolean[7777778];
    static Stack<Character> pm = new Stack<>();
    static List<Character> nums = new ArrayList<>();
    static Set<Integer> set = new HashSet<>();
    static boolean[] visited;
    static int count = 0;

    static void dfs(int depth) {
        if (depth > nums.size()) {
            return;
        }
        if (!pm.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (char x : pm) {
                sb.append(x);
            }
            int tmp = Integer.parseInt(sb.toString());
            if (isPrime[tmp]) {
                set.add(tmp);
            }
        }
        for (int i = 0; i < nums.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                pm.push(nums.get(i));
                dfs(depth + 1);
                visited[i] = false;
                pm.pop();
            }
        }
    }

    public int solution(String numbers) {

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= 7777777; i++) {
            if (isPrime[i]) {
                for (int j = i + i; j <= 7777777; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (char c : numbers.toCharArray()) {
            nums.add(c);
        }
        visited = new boolean[nums.size()];
        dfs(0);
        int answer = set.size();
        return answer;
    }
}
