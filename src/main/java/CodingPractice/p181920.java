package CodingPractice;

public class p181920 {
    public int solution(int[] num_list) {
        //product of arrays
        int product = 1;
        for (int i : num_list) {
            product *= i;
        }
        int powOfSum = 0;
        for (int i : num_list) {
            powOfSum += i;
        }
        return product < Math.pow(powOfSum, 2) ? 1 : 0;
    }
}
