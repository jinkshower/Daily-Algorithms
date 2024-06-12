package ndb;

import java.util.Stack;

public class TugOfWar {

    static Stack<Integer> pm = new Stack<>();
    static int[][] relation;
    static boolean[] visited;
    static int answer;

    static void dfs(int depth) {
        if (depth == 7) {
            answer += 1;
        } else {
            for (int i = 1; i <= 7; i++) {
                if (!pm.isEmpty() && relation[pm.peek()][i] == 1) {
                    continue;
                }
                if (!visited[i]) {
                    visited[i] = true;
                    pm.push(i);
                    dfs(depth + 1);
                    pm.pop();
                    visited[i] = false;
                }
            }
        }
    }

    public int solution(int[][] fight) {
        answer = 0;
        relation = new int[8][8];

        for (int[] x : fight) {
            relation[x[0]][x[1]] = 1;
            relation[x[1]][x[0]] = 1;
        }

        visited = new boolean[8];
        dfs(0);
        return answer;
    }
}
