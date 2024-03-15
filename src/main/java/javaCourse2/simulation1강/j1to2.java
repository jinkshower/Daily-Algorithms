package javaCourse2.simulation1강;

public class j1to2 {

    //내풀이 10:20-10:35
    public int[] solution(int[][] board, int k) {
        int[] answer = new int[2];
        //시작점
        int x = 0;
        int y = 0;
        //동쪽 보고 시작
        int direction = 0;
        //동, 남, 서, 북시 앞의 칸
        int[][] forward_dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (k > 0) {
            int nx = x + forward_dir[direction][0];
            int ny = y + forward_dir[direction][1];
            //보드 밖이면
            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board.length) {
                direction = turn(direction);
                k--;
                continue;
            }
            //벽이면
            if (board[nx][ny] == 1) {
                direction = turn(direction);
                k--;
                continue;
            }
            //전진
            x = nx;
            y = ny;
            k--;
        }
        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    public int turn(int direction) {
        return direction + 1 <= 3 ? direction + 1 : 0;
    }
}
