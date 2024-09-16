package review;

public class leetcode547 {

    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        boolean[] visited = new boolean[len];
        int count = 0;

        for (int from = 0; from < len; from++) {
            if (!visited[from]) {
                count++;
                dfs(from, isConnected, visited);
            }
        }
        return count;
    }

    private void dfs(int from, int[][] isConnected, boolean[] visited) {
        visited[from] = true;

        for (int to = 0; to < isConnected[from].length; to++) {
            if (isConnected[from][to] == 1 && !visited[to]) {
                dfs(to, isConnected, visited);
            }
        }
    }
}
