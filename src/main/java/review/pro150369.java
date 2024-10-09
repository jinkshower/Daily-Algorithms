package review;

public class pro150369 {

    public long solution2(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0, delivered = 0, pickedUp = 0;

        for (int i = deliveries.length - 1; i >= 0; i--) {
            if (deliveries[i] != 0 || pickups[i] != 0) {
                int cnt = 0;  // i번째 집에서 처리하기 위해 왕복 횟수

                // 배달 또는 수거해야 할 물량이 남아있는 경우 계속 왕복
                while (delivered < deliveries[i] || pickedUp < pickups[i]) {
                    cnt++; // 왕복 횟수 증가
                    delivered += cap;  // 한번 왕복할 때 cap만큼 배달할 수 있음
                    pickedUp += cap;   // 한번 왕복할 때 cap만큼 수거할 수 있음
                }

                // 배달하고 남은 물량을 delivered에서 차감
                delivered -= deliveries[i];
                // 수거하고 남은 물량을 pickedUp에서 차감
                pickedUp -= pickups[i];

                // 총 이동 거리에 이번 왕복 거리를 추가
                answer += cnt * (i + 1) * 2;
            }
        }

        return answer;
    }


    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int wholeOffset = n - 1;
        while (deliveries[wholeOffset] == 0 && pickups[wholeOffset] == 0) {
            wholeOffset--;
            if (wholeOffset < 0) {
                break;
            }
        }
        int delOffset = wholeOffset;
        int pickOffset = wholeOffset;
        while (wholeOffset >= 0) {
            int delCap = cap;
            int pickCap = cap;

            while (delOffset >= 0 && delCap > 0) {
                int curDel = deliveries[delOffset];
                if (curDel <= delCap) {
                    delCap -= curDel;
                    deliveries[delOffset] = 0;
                    delOffset--;
                } else {
                    deliveries[delOffset] = curDel - delCap;
                    delCap = 0;
                }
            }

            while (pickOffset >= 0 && pickCap > 0) {
                int curPick = pickups[pickOffset];

                if (curPick <= pickCap) {
                    pickCap -= curPick;
                    pickups[pickOffset] = 0;
                    pickOffset--;
                } else {
                    pickups[pickOffset] = curPick - pickCap;
                    pickCap = 0;
                }
            }
            // System.out.println("whole = " + wholeOffset);
            answer += (wholeOffset + 1) * 2;
            while (deliveries[wholeOffset] == 0 && pickups[wholeOffset] == 0) {
                wholeOffset--;
                if (wholeOffset < 0) {
                    break;
                }
            }
        }

        return answer;
    }
}
