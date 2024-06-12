package javaCourse2.simulation1강;

import java.util.Arrays;

public class j1to7 {

    //내풀이 시간고려 x
    public int solution(int[] keypad, String password) {
        int answer = 0;
        int first = password.charAt(0) - '0';
        //첫 위치
        int x = -1;
        int y = -1;
        int[][] key = new int[3][3];
        int idx = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                key[i][j] = keypad[idx];
                if (keypad[idx] == first) {
                    x = i;
                    y = j;
                }
                idx++;
            }
        }
        // for (int i = 0; i < 3; i++) {
        //   for (int j = 0; j < 3 ;j++) {
        //     System.out.print(key[i][j] + " ");
        //   }
        //   System.out.println();
        // }
        //2번째 패스워드부터
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int i = 1; i < password.length(); i++) {
            int next = password.charAt(i) - '0';
            // System.out.println(key[x][y]);
            if (next == key[x][y]) {
                continue;
            }
            int tmpx = -1;
            int tmpy = -1;
            //8방향 탐색
            for (int j = 0; j < 8; j++) {
                int nx = x + dx[j];
                int ny = y + dy[j];
                if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) {
                    continue;
                }
                if (key[nx][ny] == next) {
                    tmpx = nx;
                    tmpy = ny;
                    break;
                }
            }

            //찾았을 경우
            if (tmpx != -1 && tmpy != -1) {
                x = tmpx;
                y = tmpy;

                // System.out.println(y);
                answer++;
                continue;
            }
            x = 1;
            y = 1;
            answer++;

            for (int j = 0; j < 8; j++) {
                int qx = x + dx[j];
                int qy = y + dy[j];
                if (qx < 0 || qx >= 3 || qy < 0 || qy >= 3) {
                    continue;
                }
                if (key[qx][qy] == next) {
                    x = qx;
                    y = qy;
                    answer++;
                    break;
                }
            }
            // System.out.println("key : " + key[nx][ny]);
            // System.out.println("next : " + next );
            // System.out.println("x : " +  x + " y  : " + y);
        }
        return answer;
    }

    //강의풀이
    public int solution2(int[] keypad, String password) {
        int answer = 0;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        int[][] pad = new int[3][3];
        int[][] dist = new int[10][10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                pad[i][j] = keypad[i * 3 + j];
            }
        }
        for (int i = 0; i < 10; i++) {
            Arrays.fill(dist[i], 2);
        }
        for (int i = 0; i < 10; i++) {
            dist[i][i] = 0;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int from = pad[i][j];
                for (int k = 0; k < 8; k++) {
                    if (i + dx[k] >= 0 && i + dx[k] < 3 && j + dy[k] >= 0 && j + dy[k] < 3) {
                        int to = pad[i + dx[k]][j + dy[k]];
                        dist[from][to] = 1;
                    }
                }
            }
        }
        for (int i = 1; i < password.length(); i++) {
            int from = (int) password.charAt(i - 1) - 48;
            int to = (int) password.charAt(i) - 48;
            answer += dist[from][to];
        }
        return answer;
    }
}
