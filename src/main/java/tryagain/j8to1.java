package tryagain;

import java.util.Scanner;

//합이 같은 부분집합 다시 풀기
public class j8to1 {

    static String answer = "NO";
    static int n;
    static int total;
    static boolean flag = false;

    public static void dfs(int L, int sum, int[] arr) {
        if (flag) {
            return;
        }
        if (L == n) {
            if (total - sum == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            dfs(L + 1, sum + arr[L], arr);
            dfs(L + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            arr[i] = tmp;
            total += tmp;
        }

        dfs(0, 0, arr);
    }
}
