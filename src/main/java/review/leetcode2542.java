package review;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class leetcode2542 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        List<int[]> pairs = new ArrayList<>();
        // 결과에 영향을 미치는 요소 중 하나를 컨트롤한다
        // nums2 를 내림차순으로 정렬한다. -> min값을 갱신하면 되므로 신경쓸 필요가 없어진다.
        for (int i = 0; i < nums1.length; i++) {
            pairs.add(new int[]{nums1[i], nums2[i]});
        }

        pairs.sort((a, b) -> b[1] - a[1]);
        // sum을 갱신할 때는 Greedy한 접근법으로 모든 경우의 수를 탐색하는 것보다
        // 가장 작은 값을 빼가면서 sum을 갱신하면 그 보다 작은 경우의 수는 신경 안써도 된다
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        long sum = 0;
        long result = -1;

        for (int[] pair : pairs) {
            sum += pair[0];

            minHeap.offer(pair[0]);
            // k가 넘는 갯수가 들어오면
            if (minHeap.size() > k) {
                //최솟값을 합에서 빼고
                int popped = minHeap.poll();
                sum -= popped;
            }
            // result를 갱신한다
            if (minHeap.size() == k) {
                result = Math.max(result, sum * pair[1]);
            }
        }
        return result;
    }
}
