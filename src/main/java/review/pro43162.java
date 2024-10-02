package review;

public class pro43162 {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                recur(i, computers, visited);
                answer++;
            }
        }
        return answer;
    }

    private void recur(int start, int[][] computers, boolean[] visited) {
        for (int i = 0; i < computers[start].length; i++) {
            if (computers[start][i] == 1 && !visited[i]) {
                visited[i] = true;
                recur(i, computers, visited);
            }
        }
    }
}
