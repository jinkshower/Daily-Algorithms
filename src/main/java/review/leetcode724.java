package review;

public class leetcode724 {

	public int pivotIndex(int[] nums) {
		//이진 검색이 가장 먼저 떠오름.
		//left most -> parametric
		//예외 상황 원소가 1개 일때는?
//		int len = nums.length;
		// int start = 0;
		// int end = len - 1;

		// int result = -1;
		// while (start <= end) {
		//     int mid = start + (end - start) / 2;

		//     if (check(nums, mid)) {
		//         result = mid;
		//         //만족하므로 더 낮은 인덱스를 탐색
		//         end = mid - 1;
		//     } else {
		//         //만족하지 않으므로 더 높은 인덱스를 탐색
		//         start = mid + 1;
		//     }
		// }

		//이분 탐색을 사용할 수 없음. 반으로 범위를 줄이는게 불가능함.
		// for (int i = 0; i < nums.length; i++) {
		//     if (check(nums, i)) {
		//         return i;
		//     }
		// }

		//너무 느림
		//누적합?

		int[] culSum = new int[nums.length + 1];

		culSum[0] = 0;
		for (int i = 1; i < culSum.length; i++) {
			culSum[i] = culSum[i - 1] + nums[i - 1];
		}

		// System.out.println(Arrays.toString(culSum));

		for (int i = 1; i < culSum.length; i++) {
			//왼쪽 구간합
			int leftSum = culSum[i - 1];
			//오른쪽 구간합
			int rightSum = culSum[culSum.length - 1] - culSum[i];

			if (leftSum == rightSum) {
				return i - 1;
			}
		}

		return -1;
	}

	// private boolean check(int[] nums, int pivot) {
	//     int leftSum = 0;
	//     int rightSum = 0;
	//     //0 ~ nums[pivot -1] 까지의 합
	//     for (int i = 0; i < pivot; i++) {
	//         leftSum += nums[i];
	//     }

	//     //pivot + 1 ~ nums[nums.lenth -1] 까지의 합
	//     for (int i = pivot + 1; i < nums.length; i++) {
	//         rightSum += nums[i];
	//     }

	//     System.out.println("leftSum = " + leftSum + "rightSum = " + rightSum);

	//     return leftSum == rightSum;
	// }
}
