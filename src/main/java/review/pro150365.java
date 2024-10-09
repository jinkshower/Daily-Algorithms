package review;

public class pro150365 {
    static String answer = "impossible";  // 초기 값은 불가능한 경로
    static int[] dx = {1, 0, 0, -1};  // D, L, R, U에 해당하는 이동
    static int[] dy = {0, -1, 1, 0};
    static char[] dir = {'d', 'l', 'r', 'u'};  // 명령어 순서: D > L > R > U
    static int n, m, r, c, k;

    public String solution(int n_, int m_, int x, int y, int r_, int c_, int k_) {
        n = n_;
        m = m_;
        r = r_;
        c = c_;
        k = k_;

        int distance = Math.abs(r - x) + Math.abs(c - y);  // 현재 위치에서 목표까지의 거리

        // 만약 이동 가능한 거리가 짝수가 아니거나, 남은 거리가 k보다 크면 불가능
        if (distance > k || (k - distance) % 2 != 0) {
            return "impossible";
        }

        dfs(x, y, 0, new StringBuilder());  // 깊이 우선 탐색 시작
        return answer;
    }

    private void dfs(int x, int y, int moves, StringBuilder path) {
        // 이미 답을 찾았으면 더 이상 탐색할 필요 없음
        if (!answer.equals("impossible")) {
            return;
        }

        // 남은 거리와 이동 횟수 체크
        int remainingMoves = k - moves;
        int distanceToTarget = Math.abs(r - x) + Math.abs(c - y);

        // 남은 거리보다 이동 횟수가 부족하거나 남은 이동 횟수와 거리가 맞지 않으면 중단
        if (distanceToTarget > remainingMoves || (remainingMoves - distanceToTarget) % 2 != 0) {
            return;
        }

        // 이동 횟수가 k에 도달했을 때
        if (moves == k) {
            if (x == r && y == c) {  // 목표에 도달한 경우
                answer = path.toString();  // 가장 빠른 경로를 저장
            }
            return;
        }

        // 사전순으로 D, L, R, U 순서로 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위를 벗어나지 않는지 확인
            if (nx < 1 || ny < 1 || nx > n || ny > m) {
                continue;
            }

            // 백트래킹으로 다음 경로 탐색
            path.append(dir[i]);
            dfs(nx, ny, moves + 1, path);
            path.deleteCharAt(path.length() - 1);  // 탐색 후 경로 복구
        }
    }
}
