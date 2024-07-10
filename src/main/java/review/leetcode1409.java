package review;

public class leetcode1409 {

	public int[] processQueries(int[] queries, int m) {
		// m <= 1000
		// 3 1 2 1
		// for i = 0, queries[i] = 3.
		// move 3 to the beginning of result.
		// record original position of 3 in numbers.
		// 첫번째 풀이.
		// List<Integer> numbers = new LinkedList<>();
		// for (int i = 0; i < m; i++) {
		//     numbers.add(i + 1);
		// }

		// int[] result = new int[queries.length];
		// int i = 0;
		// for (int query : queries) {
		//     int curIdx = numbers.indexOf(query);
		//     numbers.remove(curIdx);
		//     numbers.addFirst(query);
		//     result[i] = curIdx;
		//     i++;
		// }
		// return result;
		//연결 리스트 말고 배열로 풀어보자.
		int[] arr = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = i + 1;
		}

		for (int i = 0; i < queries.length; i++) {
			queries[i] = findIndex(arr, queries[i]);
		}
		return queries;
	}

	private int findIndex(int[] arr, int target) {
		int found = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				updateIndex(arr, i, target);
				found = i;
				break;
			}
		}
		return found;
	}

	private void updateIndex(int[] arr, int from, int target) {
		for (int i = from; i > 0; i--) {
			arr[i] = arr[i - 1];
		}
		arr[0] = target;
	}
}
