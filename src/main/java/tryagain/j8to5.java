package tryagain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//동전교환 dfs 다시풀기
public class j8to5 {

    static int n;//동전종류 개수
    static int m;//거슬러줄 금액
    static int[] pm;
    static int answer = Integer.MAX_VALUE;

    //L == 동전 개수
    public static void dfs(int L, int sum, Integer[] arr) {
        if (L > answer) {
            return;
        }
        if (sum > m) {
            return;
        }
        if (sum == m) {
            answer = Math.min(answer, L);
        } else {
            for (int i = 0; i < n; i++) {
                dfs(L + 1, sum + arr[i], arr);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        m = sc.nextInt();
        dfs(0, 0, arr);
        System.out.println(answer);
    }
}
