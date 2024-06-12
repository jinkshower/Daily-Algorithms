package javaCourse2.hasing2강;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class j2to6 {

    //내풀이 945 - 959
    class Person implements Comparable<Person> {

        public String name;
        public int time;

        Person(String name, int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public int compareTo(Person o) {
            return this.time - o.time;
        }
    }

    public String[] solution(String[] reports, String times) {
        // String[] answer = {};
        Map<String, Integer> rMap = new HashMap<>();

        int[] time = new int[2];
        String[] blankSplit = times.split(" ");
        for (int i = 0; i < blankSplit.length; i++) {
            time[i] = toMin(blankSplit[i]);
        }
        // System.out.println(Arrays.toString(time));
        List<Person> list = new ArrayList<>();
        for (String report : reports) {
            String[] rSplit = report.split(" ");
            if (toMin(rSplit[1]) >= time[0] && toMin(rSplit[1]) <= time[1]) {
                list.add(new Person(rSplit[0], toMin(rSplit[1])));
            }
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).name;
        }
        return answer;
    }

    public int toMin(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
