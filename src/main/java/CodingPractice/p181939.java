package CodingPractice;

public class p181939 {
    public int solution(int a, int b) {
        int answer =0;
        String aFirstStr = String.valueOf(a) + String.valueOf(b);
        String bFirstStr = String.valueOf(b) + String.valueOf(a);
        int aFirstInt = Integer.parseInt(aFirstStr);
        int bFirstInt = Integer.parseInt(bFirstStr);
        if (aFirstInt >= bFirstInt) {
            answer = aFirstInt;
        } else {
            answer = bFirstInt;
        }
        return answer;
//
//        int aFirst = Integer.parseInt("" + a + b);
//        int bFirst = Integer.parseInt("" + b + a);
//        return Math.max(aFirst, bFirst);

    }
}
