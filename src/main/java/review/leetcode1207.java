package review;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class leetcode1207 {

	public boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> hash = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			hash.put(arr[i], hash.getOrDefault(arr[i], 0) + 1);
		}
		int size = hash.values().size();
		Set<Integer> set = new HashSet<>(hash.values());
		return size == set.size();
	}
}
