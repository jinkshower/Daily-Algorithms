package CodingPractice;

public class p82612 {
    public long solution(int price, int money, int count) {
        long sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += (long) price * i;
        }
        return sum > money ? sum - money : 0;
    }
}
