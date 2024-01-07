package CodingPractice;

public class p12932 {
    public int[] solution(long n) {
        int size = (int) Math.log10(n) + 1;
        int[] answer = new int[size];
        int i = 0;
        while (n != 0) {
            long lastDigit = n % 10;
            answer[i] = (int) lastDigit;
            n /= 10;
            i++;
        }
        return answer;
    }
}
