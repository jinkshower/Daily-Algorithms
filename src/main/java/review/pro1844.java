package review;

import java.util.LinkedList;
import java.util.Queue;

public class pro1844 {
    static final int WALL = 0;
    static final int EMPTY = 1;

    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;

        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        visited[0][0] = true;
        q.offer(new int[]{0, 0});

        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (maps[nx][ny] != WALL && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return distance[n - 1][m - 1] == 0 ? -1 : distance[n - 1][m - 1] + 1;
    }
}
