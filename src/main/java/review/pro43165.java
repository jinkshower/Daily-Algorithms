package review;

public class pro43165 {
    static int answer;

    public int solution(int[] numbers, int target) {
        recur(numbers, 0, target, 0);
        return answer;
    }

    private void recur(int[] numbers, int depth, int target, int sum) {
        if (depth == numbers.length) {
            if (target == sum) {
                answer++;
            }
            return;
        }

        recur(numbers, depth + 1, target, sum + numbers[depth]);
        recur(numbers, depth + 1, target, sum - numbers[depth]);
    }
}
