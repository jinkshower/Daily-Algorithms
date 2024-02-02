package CodingPractice;

public class p12945 {
    public int solution(int n) {
        int answer = 0;
        int divisor = 1234567;
        int a = 1;
        int b = 0;
        for (int i = 2; i <= n; i++) {
            answer = ((a % divisor) + (b % divisor)) % divisor;
            b = a;
            a = answer;
        }

        return answer;
    }
}
