package review;

public class leetcode1861 {

	private static final char STONE = '#';
	private static final char OBSTACLE = '*';
	private static final char EMPTY = '.';

	public char[][] rotateTheBox(char[][] box) {
		//각 char[i] 마다 Deque를 두고 앞에서 부터 빈공간 을 앞에서 빼고 뒤에 넣는다
		//돌과 돌 사이의 빈공간을 처리한다.

		//뒤에서부터 순회하며 돌인경우 장애물/ 끝자리까지 밀어넣는다.

		//일단 돌린다.
		int m = box.length;
		int n = box[0].length;
		char[][] rotated = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				rotated[i][j] = box[m - 1 - j][i];
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = n - 1; j >= 0; j--) {
				if (rotated[j][i] == STONE) {
					int curRow = j;
					while (curRow + 1 < n && rotated[curRow + 1][i] == EMPTY) {
						curRow++;
					}
					if (curRow != j) {
						rotated[curRow][i] = STONE;
						rotated[j][i] = EMPTY;
					}
				}
			}
		}

		return rotated;
	}
}
