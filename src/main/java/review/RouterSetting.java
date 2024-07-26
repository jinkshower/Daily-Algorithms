package review;

import java.util.Arrays;
import java.util.Scanner;

public class RouterSetting {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int c = scanner.nextInt();
		int[] homes = new int[n];

		for (int i = 0; i < n; i++) {
			homes[i] = scanner.nextInt();
		}

		Arrays.sort(homes);

		int min = 1; //최소 거리는 1
		int max = homes[n - 1] - homes[0];//최대 거리는 가장 먼 집과 가장 가까운 집의 거리
		int result = 0;

		while (min <= max) {
			int mid = min + (max - min) / 2;

			if (isPossible(homes, c, mid)) { //설치 가능한 경우
				result = mid; // 최적해 일수 있으니 저장한다.
				min = mid + 1; // 설치 가능하니 더 큰 값 탐색
			} else {
				max = mid - 1; //설치 불가! 더 작은 값 탐색
			}
		}

		System.out.println(result);
	}

	private static boolean isPossible(int[] homes, int c, int mid) {
		int cnt = 1;
		int last = homes[0];

		for (int i = 1; i < homes.length; i++) {
			if (homes[i] - last >= mid) {
				cnt++;
				last = homes[i];
			}
		}

		return cnt >= c;
	}
}
