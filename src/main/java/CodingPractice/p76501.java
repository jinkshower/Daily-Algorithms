package CodingPractice;

public class p76501 {
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;
        for (int i = 0; i < absolutes.length; i++) {
            int absolute = absolutes[i];
            if (signs[i]) {
                sum += absolute;
            } else {
                sum -= absolute;
            }
        }
        return sum;
    }
}
