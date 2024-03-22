package CodingPractice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class p92334to2 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Set<String>> rMap = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        for (String r : report) {
            String[] split = r.split(" ");
            rMap.putIfAbsent(split[0], new HashSet<>());
            if (!rMap.get(split[0]).contains(split[1])) {
                rMap.get(split[0]).add(split[1]);
                count.put(split[1], count.getOrDefault(split[1], 0) + 1);
            }
        }

        Map<String, Integer> mail = new HashMap<>();
        for (String id : id_list) {
            mail.put(id, 0);
        }

        for (String rKey : rMap.keySet()) {
            Set<String> set = rMap.get(rKey);
            for (String s : set) {
                if (count.get(s) >= k) {
                    mail.put(rKey, mail.get(rKey) + 1);
                }
            }
        }
        // System.out.println(rMap);
        // System.out.println(count);
        // System.out.println(mail);

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mail.get(id_list[i]);
        }

        return answer;
    }
}
