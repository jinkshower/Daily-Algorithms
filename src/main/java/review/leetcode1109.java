package review;

public class leetcode1109 {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        //  n <= 20000
        //  bookings length <= 20000
        // seats <= 10000
        // Map<Integer, Integer> hash = new HashMap<>();
        // for (int i = 1; i <=n; i++) {
        //     hash.put(i ,0);
        // }

        // for (int[] booking : bookings) { // n = 20000
        //     int from = booking[0];
        //     int to = booking[1];
        //     int seats = booking[2];

        //     for (int i = from; i <= to; i++) { // n = 20000
        //         int now = hash.get(i);
        //         hash.put(i, now + seats);
        //     }
        // }

        // // System.out.println(hash);
        // int[] answer = new int[n];
        // int index = 0;
        // for (int i = 1; i <= n; i++) {
        //     answer[index++] = hash.get(i);
        // }
        // return answer;
        int[] sweep = new int[n + 1];  // Step 1: Create sweep array

        // Step 2: Update sweep array based on bookings
        for (int i = 0; i < bookings.length; i++) {
            sweep[bookings[i][0] - 1] += bookings[i][2];
            sweep[bookings[i][1]] -= bookings[i][2];
        }

        // Step 3: Calculate cumulative sum
        int[] answer = new int[n];
        answer[0] = sweep[0];
        for (int i = 1; i < n; i++) {
            answer[i] = sweep[i] + answer[i - 1];
        }

        return answer;  // Step 4: Return final result
    }
}
