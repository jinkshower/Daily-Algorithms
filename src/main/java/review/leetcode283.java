package review;

public class leetcode283 {

	public void moveZeroes(int[] nums) {
		// Deque<Integer> queue = new ArrayDeque<>();
		// int cnt = 0;
		// for (int i : nums) {
		//     if (i != 0){
		//         queue.offer(i);
		//     } else {
		//         cnt++;
		//     }
		// }
		// int size = queue.size();//1
		// System.out.println(cnt);
		// System.out.println(size);
		// for (int i = 0; i < size; i++) {
		//     nums[i] = queue.poll();
		// }

		// for (int i = size; i < size + cnt; i++) {
		//     nums[i] = 0;
		// }

		//two pointer
		// int right = 0;
		// for (int left = 0; left < nums.length; left++) {
		//     if (right >= nums.length - 1) break;
		//     while(right < nums.length - 1 && nums[right] == 0) {
		//         right++;
		//     }
		//     //바꿀 필요가 없는 인덱스임.
		//     if (left == right) {
		//         right++;
		//         continue;
		//     }
		//     swap(nums, left, right);
		// }

		int lastZero = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[lastZero] = nums[i];
				lastZero++;
			}
		}

		for (int i = lastZero; i < nums.length; i++) {
			nums[i] = 0;
		}
	}

	// private void swap(int[] nums, int left, int right) {
	//     int tmp;
	//     tmp = nums[left];
	//     nums[left] = nums[right];
	//     nums[right] = tmp;
	// }
}
