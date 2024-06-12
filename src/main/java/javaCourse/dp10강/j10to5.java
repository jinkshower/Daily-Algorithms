package javaCourse.dp10강;

import java.util.Arrays;
import java.util.Scanner;

public class j10to5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            for (int j = cur; j <= target; j++) {
                dp[j] = Math.min(dp[j - cur] + 1, dp[j]);
            }
        }
        System.out.println(dp[target]);
    }
}
