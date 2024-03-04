package CodingPractice;

import java.util.List;

public class p84512 {

    public int solution(String word) {
        List<String> list = List.of("A", "E", "I", "O", "U");
        pm = new String[6];
        target = word;
        dfs(0, list);
        return answer;
    }

    static String[] pm;
    static int count = -1;
    static int answer = 0;
    static String target;

    public void dfs(int L, List<String> list) {
        if (L == 6) {
            return;
        } else {
            count++;
            String tmp = "";
            for (int i = 0; i < L; i++) {
                tmp += pm[i];
            }
            // System.out.println(tmp);
            if (tmp.equals(target)) {
                answer = count;
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                pm[L] = list.get(i);
                dfs(L + 1, list);
            }
        }
    }
}
