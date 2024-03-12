package CodingPractice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class p155651 {

    //pq
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] book = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end = Integer.parseInt(book_time[i][1].replace(":", ""));

            end += 10;
            if (end % 100 >= 60) {
                end += 40;
            }

            book[i][0] = start;
            book[i][1] = end;
        }
        Arrays.sort(book, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[1]));
        for (int[] b : book) {
            if (pq.isEmpty()) {
                pq.offer(b);
            } else {
                int[] cur = pq.peek();
                if (b[0] >= cur[1]) {
                    pq.poll();
                }
                pq.offer(b);
            }
        }

        return pq.size();
    }

    //누적합
    static final int MAX_TIME = 1450;
    static final int HOUR = 60;
    static final int CLEAN_TIME = 10;

    public int solution2(String[][] book_time) {
        int answer = 0;
        int[] rooms = new int[MAX_TIME];
        for (String[] time : book_time) {
            String inTime = time[0];
            String outTime = time[1];

            int inTimei = calTime(inTime);
            int outTimei = calTime(outTime) + CLEAN_TIME;
            rooms[inTimei] += 1;

            rooms[outTimei] += -1;
        }

        for (int i = 1; i < MAX_TIME; i++) {
            rooms[i] += rooms[i - 1];
            answer = Math.max(answer, rooms[i]);
        }
        return answer;
    }

    public int calTime(String time) {
        String[] split = time.split(":");
        String hour = split[0];
        String minute = split[1];
        return Integer.parseInt(hour) * HOUR + Integer.parseInt(minute);
    }
}
