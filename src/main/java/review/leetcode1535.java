package review;

public class leetcode1535 {

	public int getWinner(int[] arr, int k) {
		//길이가 10만이고 k번 연속 이겨야 하는게 10억임.
		//k가 length보다 같거나 크면 무조건 최대값.
		//-> 즉 뒤에 넣은 값이 다시 비교될 일이 있다면 최대값이 답이 된다는 뜻..
		//따라서 원소 바뀌는 걱정을 할 필요 없이 그냥 비교하고 wins를 수행하면 된다.
		int cur = arr[0];
		int wins = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > cur) {
				cur = arr[i];
				wins = 1;
			} else {
				wins++;
			}

			if (wins == k) {
				return cur;
			}
		}
		return cur;
		//첫 풀이
		//    int len = arr.length;
		//     Deque<Integer> queue = new LinkedList<>();
		//     int max = 0;
		//     for (int i = 0; i < len; i++) {
		//         queue.offerLast(arr[i]);
		//         max = Math.max(arr[i], max);
		//     }
		//     if (k >= len) {
		//         return max;
		//     }

		//     int prevWinner = 0;
		//     int winCount = 1;
		//     while (true) {
		//         int left = queue.poll();
		//         int right = queue.poll();

		//         int winner = left > right ? left : right;
		//         int loser = left > right ? right : left;

		//         if (prevWinner == winner) {
		//             winCount++;
		//             queue.offerFirst(winner);
		//             queue.offerLast(loser);
		//         } else {
		//             winCount = 1;
		//             prevWinner = winner;
		//             queue.offerFirst(winner);
		//             queue.offerLast(loser);
		//         }
		//         if (winCount == k) {
		//             return winner;
		//         }
		//     }

	}
}
