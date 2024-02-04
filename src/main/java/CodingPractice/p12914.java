package CodingPractice;

public class p12914 {
    public long solution(int n) {
        long answer = 0;
        int a = 0;
        int b = 1;
        int div = 1234567;
        for (int i = 1; i <= n; i++) {
            answer = ((a % div) + (b % div)) % div;
            a = b;
            b = (int) answer;
        }
        return answer;
    }
}
