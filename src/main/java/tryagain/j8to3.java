package tryagain;

import java.util.Scanner;

//최대점수 구하기 다시풀기
public class j8to3 {

    static int n;//문제 개수
    static int m;//제한 시간
    static int answer;

    public static void dfs(int L, int Ssum, int Tsum, int[][] arr) {
        if (Tsum > m) {
            return;
        }
        if (L == n) {
            answer = Math.max(answer, Ssum);
        } else {
            dfs(L + 1, Ssum + arr[L][0], Tsum + arr[L][1], arr);
            dfs(L + 1, Ssum, Tsum, arr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        dfs(0, 0, 0, arr);
        System.out.println(answer);
    }
}
