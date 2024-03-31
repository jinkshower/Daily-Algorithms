package tryagain;

import java.util.Scanner;

//바둑이 승차 다시풀기
public class j8to2 {

    static int c;//최대무게
    static int n;
    static int answer;

    public static void dfs(int L, int sum, int[] arr) {
        if (sum > c) {
            return;
        }
        if (L == n) {
            if (sum <= c) {
                answer = Math.max(answer, sum);
            }
        } else {
            dfs(L + 1, sum + arr[L], arr);
            dfs(L + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(0, 0, arr);
        System.out.println(answer);
    }
}
