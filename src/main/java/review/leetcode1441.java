package review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode1441 {

	public static final String PUSH = "Push";
	public static final String POP = "Pop";

	public List<String> buildArray(int[] target, int n) {
		//target is strictly increasing.
		// 3, 5 n = 6;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.offer(i);
		}
		List<String> order = new ArrayList<>();

		for (int i = 0; i < target.length; i++) {
			int cur = target[i];
			int qCur = queue.poll();
			if (cur > qCur) {
				int diff = cur - qCur;
				for (int j = 0; j < diff; j++) {
					order.add(PUSH);
					order.add(POP);
					queue.poll();
				}
			}
			order.add(PUSH);
		}

		return order;
	}
}
