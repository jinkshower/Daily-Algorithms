package CodingPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p92341 {

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();

        for (String record : records) {
            String[] split = record.split(" ");

            //분 계산
            String[] minSp = split[0].split(":");
            int min = Integer.parseInt(minSp[0]) * 60 + Integer.parseInt(minSp[1]);

            if (split[2].equals("IN")) {
                map.put(split[1], min);
            } else {
                int curIn = map.get(split[1]);
                int curTotal = total.getOrDefault(split[1], 0);

                curTotal += min - curIn;

                total.put(split[1], curTotal);
                //출차 처리
                map.put(split[1], -1);
            }
        }
        //출차 시간 없는 기록 처리
        for (String key : map.keySet()) {
            if (map.get(key) != -1) {
                int curIn = map.get(key);
                int curTotal = total.getOrDefault(key, 0);

                curTotal += 23 * 60 + 59 - curIn;
                total.put(key, curTotal);
            }
        }
        //비용 계산
        for (String key : total.keySet()) {
            int sum = 0;
            int curTo = total.get(key);
            sum += fees[1];
            curTo -= fees[0];
            if (curTo <= 0) {
                total.put(key, sum);
            } else {
                int token = (int) Math.ceil((double) curTo / (double) fees[2]);
                sum += token * fees[3];
                total.put(key, sum);
            }
        }

        List<String> keys = new ArrayList<>(total.keySet());
        Collections.sort(keys);

        int[] answer = new int[keys.size()];
        for (int i = 0; i < keys.size(); i++) {
            answer[i] = total.get(keys.get(i));
        }

        return answer;
    }
}
