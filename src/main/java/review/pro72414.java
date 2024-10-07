package review;

public class pro72414 {

    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = parseStringTime(play_time);
        int advTime = parseStringTime(adv_time);
        int[] times = new int[playTime + 1];

        for (String log : logs) {
            int[] fromTo = parseFromTo(log);
            times[fromTo[0]]++;
            times[fromTo[1]]--;
        }

        long[] sum = new long[playTime + 1];
        sum[0] = times[0];
        for (int i = 1; i <= playTime; i++) {
            sum[i] = sum[i - 1] + times[i];
        }

        for (int i = 1; i <= playTime; i++) {
            sum[i] += sum[i - 1];
        }

        long maxSum = sum[advTime - 1];
        int maxIdx = 0;
        for (int i = advTime; i <= playTime; i++) {
            long totalSum = sum[i] - sum[i - advTime];
            if (totalSum > maxSum) {
                maxSum = totalSum;
                maxIdx = i - advTime + 1;
            }
        }

        return parseIntTime(maxIdx);
    }

    private int parseStringTime(String time) {
        String[] split = time.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        int second = Integer.parseInt(split[2]);

        return hour * 3600 + minute * 60 + second;
    }

    private int[] parseFromTo(String fromTo) {
        String[] split = fromTo.split("-");
        int start = parseStringTime(split[0]);
        int end = parseStringTime(split[1]);
        return new int[]{start, end};
    }

    private String parseIntTime(int time) {
        int hour = time / 3600;
        int minute = (time % 3600) / 60;
        int second = time % 60;
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
