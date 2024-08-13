package review;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcode1801 {
    public int getNumberOfBacklogOrders(int[][] orders) {
        //pq 2개로 가장 작은 sell order(1) , 가장 큰 buy order(0)을 poll하고
        //이 때 pq에 저장하는 것은 [price, amount]
        //poll하고 조건이 맞으면 amount 감소. amount가 남아 있다면 다시 offer. 아니면 다음 꺼 poll()
        PriorityQueue<int[]> sellPQ = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> buyPQ = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int[] order : orders) {
            //if it's buy order
            if (order[2] == 0) {
                //비어있다면 넣고 continue
                if (sellPQ.isEmpty()) {
                    buyPQ.offer(order);
                    continue;
                }
                //sell에서 지금 buy오더보다 작은 값이 있다면
                while (!sellPQ.isEmpty() && sellPQ.peek()[0] <= order[0]) {
                    int[] leastSell = sellPQ.poll();
                    int current = order[1];
                    int polled = leastSell[1];
                    if (current > polled) {
                        order[1] = current - polled;
                    } else if (current == polled) {
                        order[1] = 0;
                        break;
                    } else {
                        leastSell[1] = polled - current;
                        order[1] = 0;
                        sellPQ.offer(leastSell);
                        break; //이거 지울지 말지
                    }
                }

                if (order[1] > 0) {
                    buyPQ.offer(order);
                }
            } else {

                if (buyPQ.isEmpty()) {
                    sellPQ.offer(order);
                    continue;
                }

                while (!buyPQ.isEmpty() && buyPQ.peek()[0] >= order[0]) {
                    int[] highestBuy = buyPQ.poll();
                    int current = order[1];
                    int polled = highestBuy[1];

                    if (current > polled) {
                        order[1] = current - polled;
                    } else if (current == polled) {
                        order[1] = 0;
                        break;
                    } else {
                        highestBuy[1] = polled - current;
                        order[1] = 0;
                        buyPQ.offer(highestBuy);
                        break;
                    }
                }
                if (order[1] > 0) {
                    sellPQ.offer(order);
                }
            }
        }
        int result = 0;
        int mod = 1000000007;
        for (int[] order : sellPQ) {
            System.out.println("sellPQ = " + Arrays.toString(order));
            result = (result + order[1]) % mod;
        }
        for (int[] order : buyPQ) {
            System.out.println("buyPQ = " + Arrays.toString(order));
            result = (result + order[1]) % mod;
        }

        return result;
    }

}
