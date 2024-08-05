package review;

public class leetcode1781 {

	public int beautySum(String s) {
		int result = 0;

		for (int i = 0; i < s.length(); i++) {
			int[] count = new int[26];

			for (int j = i; j < s.length(); j++) {
				//매번 새로운 substring을 만드는게 아니라
				//count는 그대로니가 count만 더해서 계산
				count[s.charAt(j) - 'a']++;
				result += findBeauty(count);
			}
		}
		return result;
	}

	private int findBeauty(int[] count) {
		int min = Integer.MAX_VALUE;
		int max = -1;
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				min = Math.min(min, count[i]);
				max = Math.max(max, count[i]);
			}
		}
		return max - min;
	}
}
