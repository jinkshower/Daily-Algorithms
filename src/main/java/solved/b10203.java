package solved;

import java.util.Arrays;

public class b10203 {

	public static void main(String[] args) {
		b10203 mainn = new b10203();
		System.out.println(mainn.find(6, 5, 2, new int[]{3, 7, 10, 13, 17, 20},
			new int[][]{{1, 10}, {3, 9}, {4, 23}, {12, 19}, {3, 15}}));
		System.out.println(mainn.find(10, 6, 0, new int[]{1, 5, 10, 20, 29, 40, 55, 64, 71, 79},
			new int[][]{{7, 60}, {20, 77}, {1, 21}, {5, 55}, {10, 71}, {22, 27}}));
	}

	public int find(int n, int q, int k, int[] devices, int[][] lanes) {
		//오름차순이네. n이하로 풀어야 한다는 의심
		//영향을 미치는 범위가 있고 이를 합해야 할 때 누적합을 사용한다.

		//누적합을 저장할 배열이 필요하겠다. 배열의 크기는?
		//주요 설비의 수 + 1 -> 누적합은 뒤에 -1을 적립하는 식으로 계산하는데 제일 마지막 설비를 사용할 경우 -1을 저장할 공간이 없다. if로 처리하기 귀찮으니 n+1으로 두자
		int[] usage = new int[n + 1];

		// 1 10이 있다고 하자. 그럼 3, 10을 찾으면 된다.
		// 이걸 어떻게 찾지? 제한사항을 본다.주요 설비 번호, 설비 번호가 다 10억이다.
		//for문으로 찾을 생각하지 말라는 것. 시작 인덱스와 끝 인덱스를 이분탐색하면 되겠다.
		//1-10일 때 어떻게 찾나? devices들 중에 1보다 크거나 같으면서 가장 작은 값이 시작 설비.

		for (int[] lane : lanes) {
			//s 는 0이어야 한다. 왜? culSum에 저장해야 하니까.
			int s = findIdx(lane[0], devices);
			int e = findIdx(lane[1], devices);
			//크거나 같은 가장 작은 값이므로 9의 경우 10의 인덱스를 반환하니 하나 줄여준다.
			if (lane[1] < devices[e]) {
				e--;
			}

			usage[s] += 1;
			usage[e + 1] -= 1;
		}
		//누적합을 갱신한다.
		//번호화 사용횟수를 배열로 저장할 자료구조
		Device[] arr = new Device[n];
		//첫번째 설비는 누적합의 기본이 된다.
		arr[0] = new Device(devices[0], usage[0]);
		for (int i = 1; i < n; i++) {
			//앞의 값을 더한다. 누적합.
			usage[i] += usage[i - 1];
			arr[i] = new Device(devices[i], usage[i]);
		}

		//저장된 arr를 사용횟수로 정렬하고 같으면 번호순으로 정렬한다.
		Arrays.sort(arr, (a, b) -> a.usage == b.usage ? a.num - b.num : b.usage - a.usage);

		//k번째의 설비 번호를 리턴한다.
		return arr[k].num;
	}

	//번호와 사용횟수를 저장할 자료구조
	static class Device {

		int num;
		int usage;

		Device(int n, int u) {
			this.num = n;
			this.usage = u;
		}
	}

	public int findIdx(int t, int[] arr) {
		//T보다 크거나 같으면서 가장 작은 값의 인덱스를 찾아야 한다.
		//이분탐색.

		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == t) {
				return mid;
			}
			if (arr[mid] > t) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}
}
