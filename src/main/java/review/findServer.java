package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class findServer {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                findServers(new int[][]{{2423, 10}, {3423, 30}, {1, 40}, {450, 50}, {1200, 60}, {2781, 100}},
                        new int[]{2, 1}))); // [3, 2]
        System.out.println(
                Arrays.toString(findServers(
                        new int[][]{{10, 50000, 100}, {1, 100000, 1100}, {51, 100000, 2100}, {90, 100000, 3100},
                                {73, 50000, 4100}}, new int[]{10, 4}))); // [4, 1]
    }

    private static int[] findServers(int[][] delays, int[] limits) {
        //각 서버 list만들기
        //정렬
        //투 포인터로 구간 수 구하기
        //넣기
        int max = -1, maxServer = -1;
        for (int i = 0; i < delays[0].length; i++) {
            List<Integer> server = new ArrayList<>();

            for (int j = 0; j < delays.length; j++) {
                server.add(delays[j][i]);
            }

            Collections.sort(server);

            int l = 0, r = 0;
            while (r < server.size()) {
                int cur = server.get(r++);

                while (server.get(l) * limits[0] <= cur || cur - server.get(l) >= limits[1] * 1000) {
                    l++;
                }

                if (r - l > max) {
                    max = r - l;
                    maxServer = i + 1;
                }
            }
        }

        return new int[]{max, maxServer};
    }
}
