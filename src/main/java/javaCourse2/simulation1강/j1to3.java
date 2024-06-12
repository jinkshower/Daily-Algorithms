package javaCourse2.simulation1강;

public class j1to3 {

    static int[] dx = {-1, 0, 1, 0}; //북 동 남 서
    static int[] dy = {0, 1, 0, -1};

    //10:45 - 11:00
    public int solution(int[][] board) {
        int answer = 0;
        int hx = -1;
        int hy = -1;
        int hd = 0;

        int dogx = -1;
        int dogy = -1;
        int dd = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 2) {
                    hx = i;
                    hy = j;
                }
                if (board[i][j] == 3) {
                    dogx = i;
                    dogy = j;
                }
            }
        }
        int min = 10000;
        while (min > 0) {
            while (true) {
                int dhx = hx + dx[hd];
                int dhy = hy + dy[hd];

                if (dhx < 0 || dhx >= 10 || dhy < 0 || dhy >= 10) {
                    hd = (hd + 1) % 4;
                    break;
                }
                if (board[dhx][dhy] == 1) {
                    hd = (hd + 1) % 4;
                    break;
                }
                hx = dhx;
                hy = dhy;
                break;
            }

            while (true) {
                int ddogx = dogx + dx[dd];
                int ddogy = dogy + dy[dd];

                if (ddogx < 0 || ddogx >= 10 || ddogy < 0 || ddogy >= 10) {
                    dd = (dd + 1) % 4;
                    break;
                }
                if (board[ddogx][ddogy] == 1) {
                    dd = (dd + 1) % 4;
                    break;
                }
                dogx = ddogx;
                dogy = ddogy;
                break;
            }
            min--;
            if (hx == dogx && hy == dogy) {
                return 10000 - min;
            }
        }
        return 0;
    }
}
