package review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pro_dp {
    static int N;
    static int[][] consult;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 상담 일 수
        consult = new int[N + 1][2];  // 상담 정보 저장할 배열
        dp = new int[N + 1];  // 메모이제이션을 위한 배열
        // Arrays.fill(dp, -1);  // dp 배열을 -1로 초기화 (방문 여부 확인용)

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            consult[i][0] = a;  // 상담 기간
            consult[i][1] = b;  // 상담 수익
        }

        for (int idx = N - 1; idx >= 0; idx--) {
            // 상담을 진행할 수 없는 경우
            if (idx + consult[idx][0] > N) {
                dp[idx] = dp[idx + 1];
            } else {
                // 상담을 진행하는 경우와 하지 않는 경우 중 더 큰 값 선택
                dp[idx] = Math.max(dp[idx + consult[idx][0]] + consult[idx][1], dp[idx + 1]);
            }
        }

        // int ans = recur(1);  // 첫 번째 날부터 시작
    }

    private static int recur(int idx) {
        // 상담 날짜가 범위를 벗어난 경우 매우 작은 값 반환
        if (idx > N + 1) {
            return Integer.MIN_VALUE;
        }
        // 마지막 날에 도달하면 0 반환 (더 이상 상담할 수 없음)
        if (idx == N + 1) {
            return 0;
        }
        // 메모이제이션이 되어 있는 경우 이미 계산된 값 반환
        if (dp[idx] != -1) {
            return dp[idx];
        }

        // 상담을 하지 않는 경우와 상담을 하는 경우 중 최대값을 dp에 저장
        dp[idx] = Math.max(recur(idx + 1), recur(idx + consult[idx][0]) + consult[idx][1]);
        return dp[idx];
    }
}
