package javaCourse2.dfs6강;

public class j6to2 {

    //스택으로 풀면 훨씬 깔끔함
    static int[][] noNear;
    static int[] ch;
    static int[] pm;
    static int cnt;

    public void dfs(int L, int[][] noNear) {
        if (L == 7) {
            cnt++;
        } else {
            for (int i = 1; i <= 7; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    if (L != 0) {
                        int before = pm[L - 1];
                        int cur = i;
                        if (noNear[before][cur] == 1) {
                            ch[i] = 0;
                            continue;
                        }
                    }
                    pm[L] = i;
                    dfs(L + 1, noNear);
                    ch[i] = 0;
                }
            }
        }
    }

    public int solution(int[][] fight) {
        int answer = 0;
        noNear = new int[8][8];
        ch = new int[8];
        pm = new int[7];
        cnt = 0;
        for (int i = 0; i < fight.length; i++) {
            int a = fight[i][0];
            int b = fight[i][1];
            noNear[a][b] = 1;
            noNear[b][a] = 1;
        }
        dfs(0, noNear);

        return cnt;
    }
}
