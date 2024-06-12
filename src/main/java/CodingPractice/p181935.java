package CodingPractice;

public class p181935 {
    public int solution(int n) {
        int answer = 0;
        if (n % 2 == 0) {
            answer = evenNumberPowSum(n);
        }
        if (n % 2 == 1) {
            answer = oddNumberSum(n);
        }
        return answer;
    }
    public int oddNumberSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                sum += i;
            }
        }
        return sum;
    }
    public int evenNumberPowSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                sum += (int) Math.pow(i, 2);
            }
        }
        return sum;
    }
}
