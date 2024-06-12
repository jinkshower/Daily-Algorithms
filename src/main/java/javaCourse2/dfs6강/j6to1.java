package javaCourse2.dfs6강;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class j6to1 {

    static int[] pm;
    static int[] ch;
    static boolean flag = false;
    static int result;

    public void dfs(int L, List<Integer> list, int n) {
        if (flag) {
            return;
        }
        if (L == list.size()) {
            int sum = 0;
            for (int x : pm) {
                sum = sum * 10 + x;
            }
            if (sum > n) {
                result = sum;
                flag = true;
                return;
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = list.get(i);
                    dfs(L + 1, list, n);
                    ch[i] = 0;
                }
            }
        }
    }

    public int solution(int n) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        int tmp = n;
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        Collections.sort(list);
        pm = new int[list.size()];
        ch = new int[list.size()];
        flag = false;
        result = -1;
        dfs(0, list, tmp);
        return result;
    }
}
