package javaCourse2.dfs6강;

import java.util.ArrayList;
import java.util.List;

public class j6to3 {

    //조합 맨날 까먹음 ㅜㅜ
    static int[] combi;
    static int diff;

    public void dfs(int L, int S, int[][] cans) {
        if (L == cans.length / 2) {
            List<Integer> list = new ArrayList<>();
            for (int x : combi) {
                list.add(x);
            }
            int bSum = 0;
            int wSum = 0;
            for (int i = 0; i < cans.length; i++) {
                if (list.contains(i)) {
                    bSum += cans[i][0];
                } else {
                    wSum += cans[i][1];
                }
            }
            diff = Math.min(diff, Math.abs(bSum - wSum));
        } else {
            for (int i = S; i <= cans.length - 1; i++) {
                combi[L] = i;
                dfs(L + 1, S + 1, cans);
            }
        }
    }

    public int solution(int[][] cans) {
        int answer = 0;
        combi = new int[cans.length / 2];
        diff = Integer.MAX_VALUE;
        dfs(0, 0, cans);
        return diff;
    }
}
