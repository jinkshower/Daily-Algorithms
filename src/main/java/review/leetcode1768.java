package review;

public class leetcode1768 {

	public String mergeAlternately(String word1, String word2) {
		char[] arr = new char[word1.length() + word2.length()];

		char[] char1 = word1.toCharArray();
		char[] char2 = word2.toCharArray();

		int left = 0;
		int right = 0;
		int idx = 0;

		while (left < word1.length() && right < word2.length()) {
			arr[idx] = char1[left];
			left++;
			idx++;

			arr[idx] = char2[right];
			right++;
			idx++;
		}

		if (left < word1.length()) {
			while (idx < arr.length) {
				arr[idx] = char1[left];
				idx++;
				left++;
			}
		}

		if (right < word2.length()) {
			while (idx < arr.length) {
				arr[idx] = char2[right];
				idx++;
				right++;
			}
		}

		return new String(arr);
	}

}
