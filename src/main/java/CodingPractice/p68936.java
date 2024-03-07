package CodingPractice;

public class p68936 {

    static int zeroC = 0;
    static int oneC = 0;

    public int[] solution(int[][] arr) {
        int[] answer = {};
        int size = arr.length;
        compress(0, 0, size, arr);
        return new int[]{zeroC, oneC};
    }

    public void compress(int x, int y, int size, int[][] arr) {
        if (isAllSame(x, y, size, arr)) {
            if (arr[x][y] == 1) {
                oneC++;
            } else {
                zeroC++;
            }
        } else {
            int next = size / 2;
            compress(x + next, y + next, next, arr);
            compress(x, y, next, arr);
            compress(x + next, y, next, arr);
            compress(x, y + next, next, arr);
        }
    }

    public boolean isAllSame(int x, int y, int size, int[][] arr) {
        int first = arr[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}
