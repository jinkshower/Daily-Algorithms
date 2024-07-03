package review;

import java.util.Arrays;

public class programmersImmi {

    public class programmers43238 {

        public long solution(int n, int[] times) {
            //for문을 도는 것보다 Arrays.sort() -> O(1) 접근이 더 빠름
            Arrays.sort(times);
            long answer = 0;
            long start = 1;
            long end = times[times.length - 1] * (long) n;

            while (start <= end) {
                long mid = (start + end) / 2;

                long sum = 0;
                //매 심사관마다 최대로 심사할 수 있는 값을 구한다
                //이를 더하면 주어진 시간내에 심사할 수 있는 사람의 수가 된다
                for (int time : times) {
                    sum += mid / time;
                }
                //사람의 수가 적다면
                if (sum < n) {
                    //이분탐색에서 오른쪽으로 옮겨야 한다
                    start = mid + 1;
                } else {
                    //사람의 수가 많다면 -> 검사 가능하면
                    //answer를 갱신하고
                    answer = mid;
                    //왼쪽을 탐색한다
                    end = mid - 1;
                }
            }

            return answer;
        }
    }
}
