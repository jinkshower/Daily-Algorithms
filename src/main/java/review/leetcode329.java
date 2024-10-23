package review;

public class leetcode329 {
    public int longestIncreasingPath(int[][] matrix) {
        int result = 1;
        int[][] cache = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result = Math.max(result, find(matrix, cache, i, j));
            }
        }
        return result;
    }

    int[] dx = new int[]{-1, 0, 0, 1};
    int[] dy = new int[]{0, -1, 1, 0};

    private int find(int[][] matrix, int[][] cache, int x, int y) {
        if (cache[x][y] != 0) {
            return cache[x][y];
        }

        int cur = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= matrix.length || ny >= matrix[x].length || matrix[nx][ny] <= matrix[x][y]) {
                continue;
            }

            cur = Math.max(cur,
                    1 + find(matrix, cache, nx, ny));// 갈수 있는 방향만큼 1재귀 = +1. 를 갈 수 있는 4방향으로 진행. 가장 큰 값을 선택하겠다
        }

        return cache[x][y] = cur;
    }
}
