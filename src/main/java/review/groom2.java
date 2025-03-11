package review;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class groom2 {
    static class Point {
        int x;
        int y;
        int moves;
    
        Point(int x, int y, int moves) {
            this.x = x;
            this.y = y;
            ;
            this.moves = moves;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        char[][] map = new char[n][n];
        int startX = -1;
        int startY = -1;
        Point[] holes = new Point[4];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < n; j++) {
                char c = line.charAt(j);
                if (c == 'S') {
                    startX = i;
                    startY = j;
                } else if (c == 'A' || c == 'a') {
                    holes[c == 'A' ? 0 : 1] = new Point(i, j, 0);
                } else if (c == 'B' || c == 'b') {
                    holes[c == 'B' ? 2 : 3] = new Point(i, j, 0);
                }
            }
        }

        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.offer(new Point(startX, startY, 0));
        visited[startX][startY] = true;

        while (q.isEmpty()) {
            Point current = q.poll();

            int isWormhole = checkWormhole(map[current.x][current.y]);
            if (isWormhole != -1) {
                Point after = holes[isWormhole];
                current = new Point(after.x, after.y, current.moves);
                if (visited[current.x][current.y]) {
                    continue;
                }
                visited[current.x][current.y] = true;
            }

            if (map[current.x][current.y] == 'E') {
                System.out.println(current.moves);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x; // dx
                int ny = current.y; // dy

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] != '1') {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny, current.moves + 1));
                }
            }
        }

        System.out.println(-1);
    }

    private static int checkWormhole(char c) {
        if (c == 'A') {
            return 0;
        }
        if (c == 'a') {
            return 1;
        }
        if (c == 'B') {
            return 2;
        }
        if (c == 'b') {
            return 3;
        }
        return -1;
    }
}
