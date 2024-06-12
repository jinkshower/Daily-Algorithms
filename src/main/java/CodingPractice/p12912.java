package CodingPractice;

public class p12912 {
    public long solution(int a, int b) {
        if (a == b) {
            return a;
        }
        int x = Math.min(a, b);
        int y = Math.max(a, b);
        long sum = 0;
        for (int i = x; i <= y; i++) {
            sum += i;
        }
        return sum;
    }
}
