package ndb;

import java.util.Arrays;

public class Bignumber {
    public void solution(int N, int K, int M, int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        int first = nums[N - 1];
        int second = nums[N - 2];

        int cnt = M / (K + 1);
        cnt += M % (K + 1);

        answer += cnt * first;
        answer += (M - cnt) * second;
        System.out.println(answer);
    }
}
