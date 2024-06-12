package CodingPractice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int cur = cal(progresses[i], speeds[i]);
            q.offer(cur);
        }
        List<Integer> result = new ArrayList<>();
        int cnt = 0;
        int fir = q.peek();
        while (!q.isEmpty()) {
            if (q.peek() <= fir) {
                q.poll();
                cnt++;
            } else {
                result.add(cnt);
                int k = q.peek();
                fir = k;
                cnt = 0;
            }
        }
        result.add(cnt);
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public int cal(int pro, int speed) {
        int cnt = 0;
        while (pro < 100) {
            pro += speed;
            cnt++;
        }
        return cnt;
    }
}
