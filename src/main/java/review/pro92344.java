package review;

public class pro92344 {
    static int[][] sum;
    static int N, M;

    public int solution(int[][] board, int[][] skill) {

        N = board.length;
        M = board[0].length;

        sum = new int[N + 1][M + 1];

        for (int[] s : skill) {
            int x1 = s[1], y1 = s[2];
            int x2 = s[3], y2 = s[4];
            int degree = s[5] * (s[0] == 1 ? -1 : 1);

            sum[x1][y1] += degree;
            sum[x1][y2 + 1] += degree * -1;
            sum[x2 + 1][y1] += degree * -1;
            sum[x2 + 1][y2 + 1] += degree;
        }

        calculate();

        int answer = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] += sum[i][j];
                if (board[i][j] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private void calculate() {
        for (int i = 0; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                sum[i][j] += sum[i][j - 1];
            }
        }

        for (int i = 0; i < M + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                sum[j][i] += sum[j - 1][i];
            }
        }
    }
}
