package review;

import java.util.ArrayDeque;
import java.util.Deque;

public class buzzbil1 {

    public static int getMaxProfit(int[] arr, int k) {
        int n = arr.length;
        int[] prefixSum = new int[n + 1];

        // Calculate prefix sum
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        int maxSum = Integer.MIN_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);

        for (int i = 1; i <= n; i++) {
            // Remove indices outside the current window
            while (!deque.isEmpty() && i - deque.peekFirst() > k) {
                deque.pollFirst();
            }

            // Calculate the current sum and update maxSum
            int currentSum = prefixSum[i] - prefixSum[deque.peekFirst()]; //구간합
            maxSum = Math.max(maxSum, currentSum);

            // Maintain a monotonic increasing deque //가장 작은 prefix값이 가장 구간합을 크게함. 그래서 큰값을 빼줌
            // -1 -1 222 -1 -1
            //일때 0 1 2 3 4 로 prefix가 완성되었다면 가장 유리한 구간합을 만드는 prefix는 2임
            while (!deque.isEmpty() && prefixSum[deque.peekLast()] >= prefixSum[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            System.out.println("deque: " + deque);
            System.out.println("currentSum: " + currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] pnl = {-1, -1, 222, -1, -1};
        int k = 3;
//        int[] pnl = {4, 3, -2, 9, -4, 2, 7};
//        int k = 6;
//        int[] pnl = {-3, 4, 3, -2, 2, 5};
//        int k = 4;
        System.out.println("Maximum profit: " + getMaxProfit(pnl, k));
    }
}
