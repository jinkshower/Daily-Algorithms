package CodingPractice;

public class p136798 {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for (int i = 0; i < number; i++) {
            int divisor_count = countDivisor(i + 1);
            System.out.println(divisor_count);
            if (divisor_count > limit) {
                answer += power;
            } else {
                answer += divisor_count;
            }
        }
        return answer;
    }

    public int countDivisor(int number) {
        int count = 0;
        for (int i = 1; i * i <= number; i++) {
            if (i * i == number) {
                count++;
            } else if (number % i == 0) {
                count += 2;
            }
        }
        return count;
    }
}
