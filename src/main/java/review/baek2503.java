package review;

import java.util.Scanner;

public class baek2503 {
    static int n;
    static int[][] hint;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 힌트의 개수 입력
        n = scanner.nextInt();
        hint = new int[n][3];

        // 힌트 입력 받기
        for (int i = 0; i < n; i++) {
            hint[i][0] = scanner.nextInt();  // 추측한 숫자
            hint[i][1] = scanner.nextInt();  // 스트라이크 수
            hint[i][2] = scanner.nextInt();  // 볼 수
        }

        // 재귀 호출 시작
        recur(0, 100);

        // 가능한 숫자 조합의 개수 출력
        System.out.println(answer);
    }

    private static void recur(int idx, int number) {
        if (idx == n) {
            answer++;
            recur(0, number + 1);
            return;
        }

        if (number == 1000) {
            return;
        }

        if (checker(idx, number)) {
            recur(idx + 1, number);
        } else {
            recur(0, number + 1);
        }
    }

    private static boolean checker(int idx, int number) {
        int _number = hint[idx][0];
        int _strike = hint[idx][1];
        int _ball = hint[idx][2];

        int strike = 0;
        int ball = 0;

        // _number의 각 자리를 분리
        int _A = _number / 100;
        int _B = (_number % 100) / 10;
        int _C = _number % 10;

        // number의 각 자리를 분리
        int A = number / 100;
        int B = (number % 100) / 10;
        int C = number % 10;

        // 숫자가 0이 포함되면 안됨
        if (A == 0 || B == 0 || C == 0) {
            return false;
        }

        // 각 숫자가 서로 달라야 함
        if (A == B || A == C || B == C) {
            return false;
        }

        // 스트라이크 체크
        if (A == _A) {
            strike++;
        }
        if (B == _B) {
            strike++;
        }
        if (C == _C) {
            strike++;
        }

        // 볼 체크
        if (A == _B || A == _C) {
            ball++;
        }
        if (B == _A || B == _C) {
            ball++;
        }
        if (C == _A || C == _B) {
            ball++;
        }

        // 스트라이크와 볼 수가 일치하면 true 반환
        return strike == _strike && ball == _ball;
    }
}
