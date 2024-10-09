package review;

public class pro150368 {

    static int[] sales = {10, 20, 30, 40};
    static int[] answer;

    public int[] solution(int[][] users, int[] emoticons) {
        int[][] emoSale = new int[emoticons.length][2];
        answer = new int[]{-1, -1};
        for (int i = 0; i < emoticons.length; i++) {
            emoSale[i][0] = emoticons[i];
        }

        recur(0, users, emoSale);

        return answer;
    }

    private void recur(int idx, int[][] users, int[][] emoSale) {
        if (idx == emoSale.length) {
            int[] tmp = calculate(users, emoSale);
            // 더큰 값을 정답으로 갱신
            if (answer[0] < tmp[0]) {
                answer = tmp;
            } else if (answer[0] == tmp[0]) {
                if (answer[1] < tmp[1]) {
                    answer = tmp;
                }
            }
            return;
        }

        for (int i = 0; i < sales.length; i++) {
            emoSale[idx][1] = sales[i];
            recur(idx + 1, users, emoSale);
        }
    }


    private int[] calculate(int[][] users, int[][] emoSale) {
        int plus = 0;
        int totalAmount = 0;

        for (int[] user : users) {
            int wantSale = user[0];
            int limit = user[1];
            int amount = 0;
            for (int[] ems : emoSale) {
                if (ems[1] >= wantSale) {
                    amount += ems[0] * (100 - ems[1]) / 100;
                }
                if (amount >= limit) {
                    plus++;
                    amount = 0;
                    break;
                }
            }
            totalAmount += amount;
        }
        return new int[]{plus, totalAmount};
    }
}
