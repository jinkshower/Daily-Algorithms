package ndb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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

    //다시 푼 결과
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        int max = list.get(n - 1);
        int maxSum = max * k + list.get(n - 2);

        int count = m / (k + 1);
        int remain = m % (k + 1);

        int sum = 0;

        sum += maxSum * count;
        sum += max * remain;

        System.out.println(sum);
    }
}
