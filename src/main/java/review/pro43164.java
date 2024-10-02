package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pro43164 {
    static List<String> result;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> (a[0] + a[1]).compareTo(b[0] + b[1]));

        boolean[] used = new boolean[tickets.length];
        List<String> path = new ArrayList<>();
        path.add("ICN");
        recur(tickets, "ICN", used, path, 0);

        String[] answer = new String[result.size()];
        int idx = 0;
        for (String s : result) {
            answer[idx] = s;
            idx++;
        }

        return answer;
    }

    static boolean found;

    private void recur(String[][] tickets, String from, boolean[] used, List<String> path, int use) {
        if (found) {
            return;
        }
        if (use == tickets.length) {
            result = new ArrayList<>(path);
            found = true;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(from)) {
                used[i] = true;
                path.add(tickets[i][1]);
                recur(tickets, tickets[i][1], used, path, use + 1);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
