package tryagain;

import java.util.Scanner;

//조합 다시풀기
public class j8to10 {

    static int n, m;
    static int[] combi;

    static void dfs(int L, int S) {
        if (L == m) {
            for (int x : combi) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = S; i <= n; i++) {
                combi[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//n에서
        m = sc.nextInt();//m개 뽑기
        combi = new int[m];
        dfs(0, 1);
    }
}
