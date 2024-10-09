package review;

import java.util.HashMap;
import java.util.Map;

public class pro258712 {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        Map<String, Integer> friendMap = new HashMap<>();
        Map<Integer, String> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            friendMap.put(friends[i], i);
            indexMap.put(i, friends[i]);
        }

        int[][] history = new int[n][n];

        for (String gift : gifts) {
            String[] split = gift.split(" ");
            String from = split[0];
            String to = split[1];

            history[friendMap.get(from)][friendMap.get(to)]++;
        }

        Map<String, Integer> sumGift = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String cur = indexMap.get(i);
            int give = 0;
            int receive = 0;
            for (int j = 0; j < n; j++) {
                give += history[i][j];
                receive += history[j][i];
            }
            sumGift.put(cur, give - receive);
        }
        int max = 0;
        Map<String, Integer> toReceive = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String cur = indexMap.get(i);
            int amount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                String other = indexMap.get(j);
                int otherIdx = friendMap.get(other);
                //선물을 주고 받았으면
                if (history[i][otherIdx] != 0 || history[otherIdx][i] != 0) {

                    //내가 더 많이 줬으면
                    if (history[i][otherIdx] > history[otherIdx][i]) {
                        amount++;
                        //같은 량을 줬으면
                    } else if (history[i][otherIdx] == history[otherIdx][i]) {
                        //내가 선물지수가 더크면
                        if (sumGift.get(cur) > sumGift.get(other)) {
                            amount++;
                        }
                    }

                } else {
                    //내 선물 지수가 더 크면
                    if (sumGift.get(cur) > sumGift.get(other)) {
                        amount++;
                    }
                }
            }
            max = Math.max(amount, max);
        }

        return max;
    }
}
