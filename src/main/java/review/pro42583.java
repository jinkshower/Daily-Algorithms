package review;

import java.util.LinkedList;
import java.util.Queue;

public class pro42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();

        for (int i = 0; i < truck_weights.length; i++) {
            trucks.offer(truck_weights[i]);
        }
        int time = 0;
        int curWeight = 0;
        while (!trucks.isEmpty()) {
            // 다리를 다 건넜다면
            if (bridge.size() == bridge_length) {
                int arrived = bridge.poll();
                curWeight -= arrived;
            }
            int top = trucks.peek();
            //무게를 버틸 수 있고
            if (curWeight + top <= weight) {
                //bridge에 빈 곳이 있다면
                if (bridge.size() < bridge_length) {
                    bridge.offer(trucks.poll());
                    curWeight += top;
                }
            } else if (curWeight + top > weight) {
                bridge.offer(0);
            }
            time++;
        }
        // bridge 마지막에 트럭이 올라가고 while 문이 끝나기 때문에
        time += bridge_length;

        return time;
    }
}
