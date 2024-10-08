package review;

public class pro92342 {
    static int maxDiff = -1;
    static int[] answer = new int[11];  // 최종 결과 저장할 배열

    public int[] solution(int n, int[] info) {
        int[] ryan = new int[11];  // 라이언의 화살 배치를 저장할 배열
        recur(10, n, info, ryan);  // 10점 구간부터 시작해서 재귀 탐색
        if (maxDiff == -1) {
            return new int[]{-1};  // 이길 방법이 없으면 -1 반환
        }
        return answer;
    }

    private void recur(int idx, int arrows, int[] apeach, int[] ryan) {
        if (idx == -1) {  // 모든 구간을 탐색했을 때
            if (arrows > 0) {
                ryan[10] += arrows;  // 남은 화살을 0점 구간에 다 쏨
            }

            int ryanScore = 0, apeachScore = 0;
            for (int i = 0; i <= 10; i++) {
                if (ryan[i] > apeach[i]) {
                    ryanScore += 10 - i;  // 라이언이 이긴 구간
                } else if (apeach[i] > 0) {
                    apeachScore += 10 - i;  // 어피치가 이긴 구간
                }
            }

            // 점수 차가 더 큰 경우 갱신
            if (ryanScore > apeachScore && ryanScore - apeachScore > maxDiff) {
                maxDiff = ryanScore - apeachScore;
                answer = ryan.clone();
            } else if (ryanScore - apeachScore == maxDiff) {
                for (int i = 10; i >= 0; i--) {
                    if (ryan[i] > answer[i]) {
                        answer = ryan.clone();
                        break;
                    } else if (ryan[i] < answer[i]) {
                        break;
                    }
                }
            }
            ryan[10] = 0;  // 0점 구간에 더했던 화살 복구
            return;
        }

        // 1. 화살을 안 쏘는 경우 (현재 점수 구간을 포기)
        recur(idx - 1, arrows, apeach, ryan);

        // 2. 화살을 쏘는 경우 (어피치보다 1발 더 쏘기)
        if (arrows > apeach[idx]) {
            ryan[idx] = apeach[idx] + 1;
            recur(idx - 1, arrows - ryan[idx], apeach, ryan);
            ryan[idx] = 0;  // 상태 복구
        }
    }
}
