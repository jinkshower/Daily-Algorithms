package review;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class leetcode2462 {
    class Worker implements Comparable<Worker> {
        int cost;
        int index;

        Worker(int cost, int index) {
            this.cost = cost;
            this.index = index;
        }

        @Override
        public int compareTo(Worker other) {
            if (this.cost == other.cost) {
                return this.index - other.index;
            }
            return this.cost - other.cost;
        }
    }

    public long totalCost(int[] costs, int k, int candidates) {

        PriorityQueue<Worker> pq = new PriorityQueue<>();
        Deque<Worker> remain = new ArrayDeque<>();
        int leftOffset = -1;
        int rightOffset = Integer.MAX_VALUE;

        if (costs.length <= candidates * 2) {
            for (int i = 0; i < costs.length; i++) {
                pq.offer(new Worker(costs[i], i));
            }
        } else {
            for (int i = 0; i < candidates; i++) {
                pq.offer(new Worker(costs[i], i));
            }
            for (int i = candidates; i < costs.length - candidates; i++) {
                remain.offer(new Worker(costs[i], i));
            }
            for (int i = costs.length - candidates; i < costs.length; i++) {
                pq.offer(new Worker(costs[i], i));
            }
            leftOffset = candidates - 1;
            rightOffset = costs.length - candidates;
        }

        System.out.println("pq size : " + pq.size());
        System.out.println("remain size : " + remain.size());

        long sum = 0;
        int leftCounter = 1;
        int rightCounter = 1;

        for (int i = 0; i < k; i++) {
            Worker polled = pq.poll();
            sum += polled.cost;
            if (polled.index <= leftOffset) {
                if (!remain.isEmpty()) {
                    System.out.println("smaller!");
                    Worker remained = remain.pollFirst();
                    remained.index -= leftCounter;
                    leftCounter++;
                    pq.offer(remained);
                }
            } else if (polled.index >= rightOffset) {
                if (!remain.isEmpty()) {
                    System.out.println("larger!");
                    Worker remained = remain.pollLast();
                    remained.index += rightCounter;
                    rightCounter++;
                    pq.offer(remained);
                }
            }
        }

        return sum;
    }
}
