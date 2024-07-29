package review;

public class leetcode1599 {

	public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
		if (boardingCost * 4 < runningCost) {
			return -1;
		}
		int waiting = 0;

		int result = -1;
		int profit = 0;
		int maxProfit = 0;
		for (int time = 0; ; time++) {
			//태우기만 하면 되나?
			//언제나 하나의 곤돌라는 빈다.
			//customer 0명 일 수 있다
			if (waiting <= 0 && time >= customers.length) {
				break;
			}
			if (time < customers.length) {
				waiting += customers[time];
			}
			// from waiting, board 4 people to gondola.
			int curBoarded = waiting >= 4 ? 4 : waiting;
			profit += curBoarded * boardingCost - runningCost;
			waiting -= curBoarded;
			if (profit > maxProfit) {
				maxProfit = profit;
				result = time + 1;
			}
		}
		return result;
	}
}
