package review;

import java.util.Arrays;

public class leetcode2352 {

	class Node {

		int[] row;

		Node(int[] row) {
			this.row = row;
		}

		public boolean equals(Node o) {
			int size = row.length;
			for (int i = 0; i < size; i++) {
				if (row[i] != o.row[i]) {
					return false;
				}
			}
			return true;
		}
	}

	public int equalPairs(int[][] grid) {
		// List<Node> rows = new ArrayList<>();
		// for (int[] row : grid) {
		//     rows.add(new Node(row));
		// }
		// int cnt = 0;
		// for (int i = 0; i < grid.length; i++) {
		//     int[] col = new int[grid.length];
		//     for (int j = 0; j < grid.length; j++) {
		//         col[j] = grid[j][i];
		//     }
		//     Node colNode = new Node(col);
		//     for (Node row : rows) {
		//         if (row.equals(colNode)) {
		//             cnt++;
		//         }
		//     }
		// }
		int len = grid.length;
		int cnt = 0;

		for (int i = 0; i < len; i++) {
			int[] col = new int[len];
			int idx = 0;
			for (int[] row : grid) {
				col[idx] = row[i];
				idx++;
			}

			for (int[] row : grid) {
				if (Arrays.equals(col, row)) {
					cnt++;
				}
			}
		}

		return cnt;
	}
}
