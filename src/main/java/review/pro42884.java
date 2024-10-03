package review;

import java.util.Arrays;

public class pro42884 {
    public int solution(int[][] routes) {

        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        int cameras = 1;  // 첫 번째 차량의 끝에 카메라를 설치
        int end = routes[0][1];  // 첫 번째 차량의 경로 끝지점에 카메라를 설치

        for (int i = 1; i < routes.length; i++) {
            // 현재 차량의 시작 지점이 이전 차량의 끝지점보다 크면 새로운 카메라 필요
            if (routes[i][0] > end) {
                cameras++;  // 새로운 카메라 설치
                end = routes[i][1];  // 새로운 차량의 끝지점에 카메라 설치
            }
        }
        return cameras;
    }
}
