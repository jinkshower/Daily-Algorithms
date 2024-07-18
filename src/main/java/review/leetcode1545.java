package review;

import java.util.ArrayList;
import java.util.List;

public class leetcode1545 {

	public char findKthBit(int n, int k) {
		//s1 = "0"
		//si = Si -1 + "1" + reverse(invert(si-1)) for i<1
		//reversedm inverts (bit change)
		//n번째 스트링의 k번째 bit!

		List<String> list = new ArrayList<>();
		list.add("0");
		for (int i = 1; i <= n; i++) {
			String before = list.get(i - 1);
			StringBuilder sb = new StringBuilder();
			sb.append(before).append("1").append(reverse(invert(before)));
			list.add(sb.toString());
		}
		String target = list.get(n);
		return target.charAt(k - 1);
	}

	private String invert(String before) {
		char[] inverted = new char[before.length()];
		int idx = 0;
		for (char c : before.toCharArray()) {
			if (c == '0') {
				inverted[idx] = '1';
			} else {
				inverted[idx] = '0';
			}
			idx++;
		}
		return new String(inverted);
	}

	private String reverse(String before) {
		StringBuilder sb = new StringBuilder(before);
		return sb.reverse().toString();
	}
}
