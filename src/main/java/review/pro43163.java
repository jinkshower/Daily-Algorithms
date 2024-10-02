package review;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class pro43163 {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        Set<String> store = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        store.add(begin);

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String cur = q.poll();

                if (cur.equals(target)) {
                    return level;
                }

                for (String word : words) {
                    if (store.contains(word)) {
                        continue;
                    }
                    if (canChange(cur, word)) {
                        store.add(word);
                        q.offer(word);
                    }
                }
            }
            level++;
        }

        return 0;
    }

    private boolean canChange(String from, String to) {
        int diffCount = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) != to.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount == 1;
    }
}
