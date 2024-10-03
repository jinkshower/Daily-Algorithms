package review;

public class pro42860 {
    public int solution(String name) {
        int totalMoves = 0;  // 상하 조작 및 좌우 이동 총 합산
        int len = name.length();
        int move = len - 1;  // 기본적으로 오른쪽으로 끝까지 가는 경우 (최대 이동)

        // 1. 각 문자에 대한 상하 조작 횟수 계산
        for (int i = 0; i < len; i++) {
            // 해당 문자를 'A'에서 해당 문자로 변환하는데 필요한 상하 조작 최소 횟수
            char target = name.charAt(i);
            totalMoves += Math.min(target - 'A', 'Z' - target + 1);

            // 2. 좌우 이동 최적화 계산
            // 연속된 'A'의 등장 이후에 다시 문자를 변경해야 하는 경우를 대비하여 좌우 이동 경로 최적화
            int nextIndex = i + 1;
            // 연속된 'A'를 뛰어넘어야 할 경우, 뛰어넘을 마지막 'A' 이후의 인덱스를 찾아 계산
            while (nextIndex < len && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }
            // 좌우 이동: (현재위치까지 왔다가 다시 돌아가는 경로 or 반대로 가는 경로) 중 최솟값
            move = Math.min(move, i + len - nextIndex + Math.min(i, len - nextIndex));
        }

        return totalMoves + move;
    }
}
