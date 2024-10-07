package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // DP 배열 초기화
        int[] dp = new int[n];
        dp[0] = 1;

        // 가장 긴 감소하는 부분 수열 찾기
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {  // i보다 앞에 있는 숫자들과 비교
                if (numbers[j] > numbers[i]) {  // 감소하는 부분 수열 조건
                    max = Math.max(dp[j], max);  // 앞에서 나온 dp 값 중 최대를 찾음
                }
            }
            dp[i] = max + 1;  // 해당 위치까지의 감소하는 부분 수열 길이
        }

        // DP 배열 중 가장 큰 값을 출력 (최장 감소 부분 수열의 길이)
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
