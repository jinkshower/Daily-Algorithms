package tryagain;

import java.util.Scanner;

//순열 구하기 다시풀기
public class j8to6 {

    static int n;//개수
    static int m;//뽑기
    static int[] ch;
    static int[] pm;

    //L == 동전 개수
    public static void dfs(int L, int[] arr) {
        if (L == m) {
            for (int x : pm) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm[L] = arr[i];
                    dfs(L + 1, arr);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ch = new int[n];
        pm = new int[m];
        dfs(0, arr);

    }
}
