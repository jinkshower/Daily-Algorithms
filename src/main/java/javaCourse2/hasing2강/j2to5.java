package javaCourse2.hasing2강;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class j2to5 {

    //강의 풀이
    public String solution(String[] votes, int k) {
        String answer = " ";
        Map<String, Integer> candidate = new HashMap<>();
        Map<String, Set<String>> voteHash = new HashMap<>();
        int i = 0;
        for (String vote : votes) {
            String[] split = vote.split(" ");
            voteHash.putIfAbsent(split[0], new HashSet<>());
            voteHash.get(split[0]).add(split[1]);
            candidate.put(split[1], candidate.getOrDefault(split[1], 0) + 1);
        }

        Map<String, Integer> present = new HashMap<>();
        int max = -1;
        for (String a : voteHash.keySet()) {
            int cnt = 0;
            for (String b : voteHash.get(a)) {
                if (candidate.get(b) >= k) {
                    cnt++;
                }
            }
            present.put(a, cnt);
            max = Math.max(max, cnt);
        }

        ArrayList<String> tmp = new ArrayList<>();
        for (String name : present.keySet()) {
            if (present.get(name) == max) {
                tmp.add(name);
            }
        }
        tmp.sort(String::compareTo);
        answer = tmp.get(0);
        return answer;
    }
}
