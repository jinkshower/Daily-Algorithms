package javaCourse.dfsbfs활용8강;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class j8to12 {

    static int n, m;
    static int[][] board;
    static List<Tomato> first = new ArrayList<>();
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int bfs() {
        Queue<Tomato> q = new LinkedList<>();
        for (int i = 0; i < first.size(); i++) {
            q.offer(first.get(i));
        }
        int answer = 0;
        while (!q.isEmpty()) {
            Tomato cur = q.poll();
            answer = cur.day;
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    q.offer(new Tomato(nx, ny, cur.day + 1));
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int a = sc.nextInt();
                board[i][j] = a;
                if (a == 1) {
                    first.add(new Tomato(i, j, 0));
                }
            }
        }
        if (isAllRiped()) {
            System.out.println(0);
            return;
        }

        int answer = bfs();
        if (!isAllRiped()) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }

    static class Tomato {

        public int x;
        public int y;
        public int day;

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    static boolean isAllRiped() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
