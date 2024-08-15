package review;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode649 {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();

        int n = senate.length();

        // 각 팀의 의원을 큐에 넣는다.
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        // 큐가 비어있지 않다면 반복
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            // 작은 인덱스를 가진 의원이 상대를 제거하고, 다시 큐에 들어간다.
            if (rIndex < dIndex) {
                radiant.offer(rIndex + n); // 큐의 맨 뒤에 다시 넣음
            } else {
                dire.offer(dIndex + n); // 큐의 맨 뒤에 다시 넣음
            }
        }

        // 남은 큐에 따라 결과 반환
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
