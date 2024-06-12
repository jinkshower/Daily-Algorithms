package ndb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EfficientMoney {

    //내풀이
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] memo = new int[10001];
        Arrays.fill(memo, 10001);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            list.add(cur);
            memo[cur] = 1;
        }

        memo[0] = 0;
        for (int i = 1; i <= m; i++) {
            memo[i] = 10001;
            for (int j = 0; j < n; j++) {
                if (i < list.get(j)) {
                    break;
                }
                if (memo[i - list.get(j)] != 10001) {
                    int current = memo[i - list.get(j)];
                    memo[i] = Math.min(current, memo[i]) + 1;
                }
            }
        }
        if (memo[m] == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(memo[m]);
        }
    }

    //책풀이
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 정수 N, M을 입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();

        // N개의 화폐 단위 정보를 입력 받기
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
        int[] d = new int[m + 1];
        Arrays.fill(d, 10001);

        // 다이나믹 프로그래밍(Dynamic Programming) 진행(보텀업)
        d[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= m; j++) {
                // (i - k)원을 만드는 방법이 존재하는 경우
                if (d[j - arr[i]] != 10001) {
                    d[j] = Math.min(d[j], d[j - arr[i]] + 1);
                }
            }
        }

        // 계산된 결과 출력
        if (d[m] == 10001) { // 최종적으로 M원을 만드는 방법이 없는 경우
            System.out.println(-1);
        } else {
            System.out.println(d[m]);
        }
    }
}
