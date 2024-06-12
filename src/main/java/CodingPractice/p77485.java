package CodingPractice;

public class p77485 {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows + 1][columns + 1];
        int num = 1;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                map[i][j] = num++;
            }
        }
        int idx = 0;
        int[] result = new int[queries.length];
        for (int[] query : queries) {
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];

            int ax = x1;
            int ay = y1;
            int before = map[ax][ay];
            int min = before;
            for (int i = 0; i < 4; i++) {
                if (i == 0) {
                    for (int j = y1; j < y2; j++) {
                        ay++;
                        int tmp = map[ax][ay];
                        if (tmp < min) {
                            min = tmp;
                        }
                        map[ax][ay] = before;
                        before = tmp;
                    }
                }
                if (i == 1) {
                    for (int j = x1; j < x2; j++) {
                        ax++;
                        int tmp = map[ax][ay];
                        if (tmp < min) {
                            min = tmp;
                        }
                        map[ax][ay] = before;
                        before = tmp;
                    }
                }
                if (i == 2) {
                    for (int j = y1; j < y2; j++) {
                        ay--;
                        int tmp = map[ax][ay];
                        if (tmp < min) {
                            min = tmp;
                        }
                        map[ax][ay] = before;
                        before = tmp;
                    }
                }
                if (i == 3) {
                    for (int j = x1; j < x2; j++) {
                        ax--;
                        int tmp = map[ax][ay];
                        if (tmp < min) {
                            min = tmp;
                        }
                        map[ax][ay] = before;
                        before = tmp;
                    }
                }
            }
            result[idx] = min;
            idx++;
        }
        return result;
    }
}
