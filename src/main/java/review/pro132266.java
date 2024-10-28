package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class pro132266 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        //bfs로 1~ 최단 거리 기록
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(destination);
        distance[destination] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int i = 0; i < graph.get(cur).size(); i++) {
                int to = graph.get(cur).get(i);
                if (distance[to] == -1) {
                    queue.offer(to);
                    distance[to] = distance[cur] + 1;
                }
            }
        }

        int[] answer = new int[sources.length];

        for (int i = 0; i < sources.length; i++) {
            answer[i] = distance[sources[i]];
        }
        //source마다 최단거리 append;
        return answer;
    }
}
