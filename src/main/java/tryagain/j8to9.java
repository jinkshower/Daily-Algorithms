package tryagain;

import java.util.Scanner;

//미로 탈출 다시풀기
public class j8to9 {

    static int[][] map = new int[7][7];
    static int[][] ch = new int[7][7];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer;

    public static void dfs(int x, int y) {
        if (x == 6 && y == 6) {
            answer++;
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx > 6 || ny < 0 || ny > 6) {
                    continue;
                }
                if (ch[nx][ny] == 0 && map[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    dfs(nx, ny);
                    ch[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        ch[0][0] = 1;
        dfs(0, 0);
        System.out.println(answer);
    }
}
