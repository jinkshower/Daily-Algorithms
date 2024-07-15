package review;

public class leetcode1503 {

	public int getLastMoment(int n, int[] left, int[] right) {
		//초를 기준으로 완탐하는 것은 너무 비효율적임
		//위치를 보고 초를 미리 구하는 방식이 나을 듯.
		//제한 사항 - unique. -> 정렬 가능
		//방향 바꾸기 -> 초 안셈
		//방향 바꾸는 것이 초를 안세니까 그냥 지나가는 것과 마찬가지.
		int max = 0;
		for (int l : left) {
			max = Math.max(l, max);
		}

		for (int r : right) {
			max = Math.max(n - r, max);
		}
		return max;
	}
}
