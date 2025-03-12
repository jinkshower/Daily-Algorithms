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

    public int findCircleNum2(int[][] isConnected) {
        // n <= 20
        // 1 1 0
        // 1 1 0
        // 0 0 1
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs2(i, isConnected, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs2(int i, int[][] isConnected, boolean[] visited) {
        visited[i] = true;

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                dfs2(j, isConnected, visited);
            }
        }
    }
}
