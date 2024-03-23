package javaCourse2.hasing2강;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class j2to7 {

    //9:03 - 9:17 내풀이
    public String[] solution(String[] reports, int time) {
        String[] answer = {};
        Map<String, Integer> inMap = new HashMap<>();
        Map<String, Integer> total = new HashMap<>();
        List<String> warn = new ArrayList<>();
        for (String report : reports) {
            String[] split = report.split(" ");
            String name = split[0];
            int rTime = parseTime(split[1]);
            String inOrOut = split[2];

            if (inOrOut.equals("in")) {
                inMap.put(name, rTime);
            } else if (inOrOut.equals("out")) {
                int inTime = inMap.get(name);
                total.put(name, total.getOrDefault(name, 0) + rTime - inTime);
                if (total.get(name) > time) {
                    warn.add(name);
                }
            }
        }
        Collections.sort(warn);
        String[] result = new String[warn.size()];
        for (int i = 0; i < warn.size(); i++) {
            result[i] = warn.get(i);
        }

        return result;
    }

    public int parseTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
