package review;

import java.util.Arrays;

public class leetcode452 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        // 화살 개수를 풍선의 개수로 초기화
        int arrows = 1;

        // 끝나는 지점 기준으로 정렬
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        // 첫 번째 풍선의 끝나는 지점을 end로 초기화
        int end = points[0][1];

        // 두 번째 풍선부터 비교
        for (int i = 1; i < points.length; i++) {
            // 현재 풍선의 시작 지점이 이전 풍선의 끝나는 지점보다 크면 겹치지 않음
            if (points[i][0] > end) {
                arrows++; // 새로운 화살이 필요
                end = points[i][1]; // 현재 풍선의 끝나는 지점으로 갱신
            }
        }

        return arrows;
    }
}
