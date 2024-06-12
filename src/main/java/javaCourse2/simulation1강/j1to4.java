package javaCourse2.simulation1강;

public class j1to4 {

    //못품 90도 회전할 생각을 못했음. 똑같은 방향전진인데 복잡하게 생각함
    public int[] solution(int c, int r, int k) {
        int[] answer = new int[2];
        if (k > r * c) {
            return new int[]{0, 0};
        }
        int[][] map = new int[c][r];
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int dir = 1;

        int num = 1;
        int x = 0;
        int y = 0;
        int count = 1;
        while (count < k) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx < 0 || nx >= c || ny < 0 || ny >= r || map[nx][ny] > 0) {
                dir = (dir + 1) % 4;
                continue;
            }
            map[x][y] = count;
            count++;
            x = nx;
            y = ny;
        }

        return new int[]{x + 1, y + 1};
    }
}
