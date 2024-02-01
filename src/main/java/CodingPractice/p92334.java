package CodingPractice;

import java.util.*;

public class p92334 {
    public int[] solution(String[] id_list, String[] reports, int k) {
        Map<String, Set<String>> reportMap = new LinkedHashMap<>();
        Map<String, Integer> resultMap = new HashMap<>();

        //initialize maps
        for (String id : id_list) {
            reportMap.put(id, new HashSet<>());
            resultMap.put(id, 0);
            System.out.println("id = " + id);
        }
        System.out.println("resultMap before = " + resultMap);
        //중복된 신고 제외하고 리포트맵에 넣기
        for (String report : reports) {
            String[] split = report.split(" ");
            String reporter = split[0];
            String reported = split[1];

            Set<String> reportedSet = reportMap.get(reporter);
            reportedSet.add(reported);
            reportMap.put(reporter, reportedSet);
        }

        System.out.println("reportMap = " + reportMap);
        System.out.println("resultMap = " + resultMap);

        //resultMap count update
        for (String reporter : reportMap.keySet()) {
            Set<String> reportedSet = reportMap.get(reporter);
            for (String reported : reportedSet) {
                int count = resultMap.get(reported);
                resultMap.put(reported, count + 1);
            }
        }
        System.out.println("resultMap = " + resultMap);


        // resultMap loop, see if count is >= k, and if it is increment and put into answer

        int count = 0;
        List<Integer> answer2 = new ArrayList<>();
        for (String reporter : reportMap.keySet()) {
            Set<String> reportedSet = reportMap.get(reporter);
            for (String reported : reportedSet) {
                int reportedCount = resultMap.get(reported);
                if (reportedCount >= k) {
                    count++;
                }
            }
            answer2.add(count);
            count = 0;
        }
        System.out.println("answer2 = " + answer2);
        return answer2.stream().mapToInt(Integer::intValue).toArray();
    }
}
