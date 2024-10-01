package review;

import java.util.LinkedList;
import java.util.Queue;

public class pro86971 {
    static int all;

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        //[7,3] 이라면 7부터 연결된 모든 노드를 탐색(왼쪽) (오른쪽) 탐색. ->노드 수 비교 후 갱신
        //양방향 연결 그래프를 그리고 1이렇게.
        int[][] graph = new int[n + 1][n + 1];

        for (int[] wire : wires) {
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }
        all = n;
        for (int[] wire : wires) {
            // 끊어본다
            graph[wire[0]][wire[1]] = 0;
            graph[wire[1]][wire[0]] = 0;

            //왼쪽 오른쪽 bfs로 노드를 센다
            int left = bfs(graph, wire[0]);
            int right = bfs(graph, wire[1]);
            //답 갱신
            answer = Math.min(answer, Math.abs(left - right));

            //다시 연결한다
            graph[wire[0]][wire[1]] = 1;
            graph[wire[1]][wire[0]] = 1;
        }

        return answer;
    }

    private int bfs(int[][] graph, int start) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        boolean[] visited = new boolean[all + 1];
        visited[start] = true;
        int cnt = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 0; i < graph[cur].length; i++) {
                if (!visited[i] && graph[cur][i] == 1) {
                    visited[i] = true;
                    cnt++;
                    q.offer(i);
                }
            }
        }
        return cnt;
    }
}
