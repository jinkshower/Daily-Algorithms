package CodingPractice;

import java.util.ArrayList;
import java.util.List;

public class p87946 {

    static List<Tired> list = new ArrayList<>();
    static int mine;
    static int[] combi;
    static int[] ch;
    static int len;
    static int answer = 0;

    static void dfs(int L) {
        if (L == len) {
            int cnt = 0;
            int thres = mine;
            for (int x : combi) {
                Tired cur = list.get(x);
                if (thres >= cur.min) {
                    thres -= cur.need;
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        } else {
            for (int i = 0; i < len; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    combi[L] = i;
                    dfs(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }

    public int solution(int k, int[][] dungeons) {
        mine = k;
        len = dungeons.length;
        combi = new int[len];
        ch = new int[len];
        for (int i = 0; i < len; i++) {
            int a = dungeons[i][0];
            int b = dungeons[i][1];
            list.add(new Tired(a, b));
        }

        dfs(0);
        return answer;
    }

    static class Tired {

        public int min, need;

        Tired(int min, int need) {
            this.min = min;
            this.need = need;
        }
    }
}
