package review;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode1926 {
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};
    final char WALL = '+';

    public int nearestExit(char[][] maze, int[] entrance) {

        int m = maze.length;
        int n = maze[0].length;

        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1]});
        visited[entrance[0]][entrance[1]] = true;

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();  // 현재 레벨에 있는 노드의 수

            for (int s = 0; s < size; s++) {  // 현재 레벨의 모든 노드를 처리
                int[] cur = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];

                    // 미로 범위를 벗어나는지 확인
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n) {
                        continue;
                    }

                    // 이미 방문했거나 벽이면 건너뜀
                    if (visited[nx][ny] || maze[nx][ny] == WALL) {
                        continue;
                    }

                    // 출구 확인 (미로의 테두리이고 entrance는 제외)
                    if ((nx == 0 || ny == 0 || nx == m - 1 || ny == n - 1) && !(nx == entrance[0]
                            && ny == entrance[1])) {
                        return level + 1;  // 레벨 + 1이 출구까지 도달하는 최소 이동 횟수
                    }

                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
            level++;  // 한 레벨을 다 돌면 그다음 레벨로 이동
        }
        return -1;  // 출구를 찾지 못했을 때
    }
}
