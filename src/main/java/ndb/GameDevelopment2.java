package ndb;

import java.util.Scanner;

//다시 풀기
public class GameDevelopment2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int x = sc.nextInt();
        int y = sc.nextInt();
        int direction = sc.nextInt();

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        //방문 기록
        boolean[][] visited = new boolean[n][m];
        //방향에 따른 이동 계획
        //북, 동, 남, 서
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        //출발지점 카운트
        int count = 1;
        while (true) {
            visited[x][y] = true;
            int turnTime = 0;

            while (true) {
                if (turnTime >= 4) {
                    break;
                }
                direction = turnLeft(direction);
                turnTime++;
                //방향에 따른 이동 위치
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                //가보지 않았고 바다가 아니라면
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (map[nx][ny] == 0 && !visited[nx][ny]) {
                    //전진
                    visited[nx][ny] = true;
                    x = nx;
                    y = ny;
                    count++;
                    turnTime = 0;
                }
            }
            //4방향 회전이 끝난후 후진 체크
            int bx = x + dx[back(direction)];
            int by = y + dy[back(direction)];
            //후진시 바다 라면
            if (map[bx][by] == 1) {
                break;
            } else {
                x = bx;
                y = by;
            }
        }
        System.out.println(count);
    }

    private static int turnLeft(int direction) {
        return direction == 0 ? 3 : direction - 1;
    }

    private static int back(int direction) {
        int next = 0;
        if (direction == 0) {
            next = 2;
        } else if (direction == 1) {
            next = 3;
        } else if (direction == 2) {
            next = 0;
        } else {
            next = 1;
        }
        return next;
    }
}
