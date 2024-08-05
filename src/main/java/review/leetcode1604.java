package review;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode1604 {

	public List<String> alertNames(String[] keyName, String[] keyTime) {
		Map<String, List<Integer>> map = new HashMap<>();

		//map에 이름, 들어간 시간 list로 넣기
		for (int i = 0; i < keyName.length; i++) {
			int parsed = parseTime(keyTime[i]);
			map.putIfAbsent(keyName[i], new ArrayList<>());
			map.get(keyName[i]).add(parsed);
		}
		// System.out.println(map);
		List<String> result = new ArrayList<>();

		for (Map.Entry<String, List<Integer>> e : map.entrySet()) {
			// 3이하면 탐색할 필요 없음
			if (e.getValue().size() < 3) {
				continue;
			}
			//시간대로 정렬
			Collections.sort(e.getValue());
			//2부터 시작하면 i+2 제한을 검사할 필요가 없음
			for (int i = 2; i < e.getValue().size(); i++) {
				if (e.getValue().get(i) - e.getValue().get(i - 2) <= 60) {
					result.add(e.getKey());
					//alert는 1회라도 다 카운트
					break;
				}
			}
		}
		//알파벳순 정렬
		Collections.sort(result);

		return result;
	}

	private int parseTime(String time) {
		// "09:10" -> minutes
		String[] split = time.split(":");
		return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
	}
}
