package tosremember;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class jto1 {

    public long solution(int money, long[][] stocks) {
        long answer = 0;
        PriorityQueue<Stock> pq = new PriorityQueue<>();
        for (int i = 0; i < stocks.length; i++) {
            pq.offer(new Stock(stocks[i][0], stocks[i][1]));
        }

        while (true) {
            Stock poll = pq.poll();
            if ()
        }
        return answer;
    }

    class Stock implements Comparable<Stock> {

        public long worth;
        public long price;

        Stock(long worth, long price) {
            this.worth = worth;
            this.price = price;
        }

        @Override
        public int compareTo(Stock o) {
            return (int) (o.worth - this.worth);
        }
    }

    class Solution {
        public long solution(int money, long[][] stocks) {
            long answer = 0;
            PriorityQueue<Stock> pq = new PriorityQueue<>();
            for (int i = 0; i < stocks.length; i++) {
                pq.offer(new Stock(stocks[i][0], stocks[i][1]));
            }

            while (!pq.isEmpty()) {
                Stock cur = pq.poll();
                System.out.println(cur.worth);
                if (money >= cur.price) {
                    answer += cur.worth;
                    money -= cur.price;
                }
            }
            return answer;
        }

        class Stock implements Comparable<Stock> {
            public long worth;
            public long price;

            Stock (long worth, long price) {
                this.worth = worth;
                this.price = price;
            }

            @Override
            public int compareTo(Stock o) {
                return (int) (o.worth - this.worth);
            }
        }
    }

    public int[][] solution(int servers, boolean sticky, int[] requests) {
        int[][] answer = new int[servers][requests.length / 2];
        Map<Integer, Integer> serverMap = new HashMap<>();

        if (!sticky) {
            int serverIndex = 0;
            for (int i = 0; i < requests.length; i++) {
                int request = requests[i];
                int server = serverIndex++ % servers;
                answer[server][serverMap.getOrDefault(server, 0)] = request;
                serverMap.put(server, serverMap.getOrDefault(server, 0) + 1);
            }
        } else {
            int[] prevServer = new int[requests.length / 2];
            for (int i = 0; i < requests.length; i++) {
                int request = requests[i];
                int server;
                if (i < prevServer.length) {
                    server = prevServer[i];
                } else {
                    server = (i - prevServer.length) % servers;
                    prevServer[i % prevServer.length] = server;
                }
                answer[server][serverMap.getOrDefault(server, 0)] = request;
                serverMap.put(server, serverMap.getOrDefault(server, 0) + 1);
            }
        }

        return answer;
    }

    int biggest = -1;
        for (int i = 0; i < s.length()- 2; i++) {
        if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i + 1) == s.charAt(i + 2)) {
            biggest = Math.max(biggest, Integer.parseInt(s.substring(i, i + 3)));
        }
    }
        return biggest;

    public int solution(int[] levels) {
        int len = levels.length;
        Arrays.sort(levels);

        int threshold = calculateThreshold(len);
        if (threshold == len) {
            return -1;
        }
        return levels[threshold];
    }

    private int calculateThreshold(int length) {
        return (int) Math.ceil(length * 0.75);
    }
}
