package review;

import java.util.Scanner;

public class CuttingTrees {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int m = scanner.nextInt();

		int[] trees = new int[n];
		int min = 0;
		int max = 0;

		for (int i = 0; i < n; i++) {
			trees[i] = scanner.nextInt();

			if (max < trees[i]) {
				max = trees[i];
			}
		}

		int result = 0;
		while (min <= max) { // min = 0, max = 최대 나무 높이.

			int mid = min + (max - min) / 2; //mid 값 구하기.
			long sum = 0; //나무의 합. int 범위를 넘을 수 있어서 long

			for (int tree : trees) {
				if (tree > mid) { // mid보다 낮은 것은 자를 수 없고 계산에 포함하면 음수값이 합에 들어감
					sum += (tree - mid);
				}
			}

			if (sum >= m) { //나무의 합이 충분한 경우
				result = mid; // 최적해일 수 있으니 result에 저장해야함.
				min = mid + 1;//충분하니 절단기를 올려서 더 높은 값을 탐색해야 함.
			} else { //나무의 합이 충분하지 않을 경우
				max = mid - 1;//절단기를 내려서 더 낮은 값을 탐색해야 함.
			}
		}
		System.out.println(result);
	}
}
