package review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class pro42579 {

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, PriorityQueue<int[]>> map = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            map.putIfAbsent(genres[i], new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
            map.get(genres[i]).offer(new int[]{plays[i], i});
            count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<Integer> result = new ArrayList<>();

        //count를 values순으로 정렬
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(count.entrySet());
        entryList.sort((e1, e2) -> e2.getValue() - e1.getValue());

        for (Map.Entry<String, Integer> entry : entryList) {
            PriorityQueue<int[]> q = map.get(entry.getKey());
            int cnt = 2;

            while (!q.isEmpty() && cnt > 0) {
                int[] cur = q.poll();
                result.add(cur[1]);
                cnt--;
            }
        }
        //많은 순서대로 최대 두개 poll 하며 result에 index append

        return result.stream().mapToInt(i -> i).toArray();
    }
}
