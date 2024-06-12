package CodingPractice;

public class p43165 {

    public int solution(int[] numbers, int target) {
        t = target;
        dfs(0, 0, numbers);
        return answer;
    }

    static int t;
    static int answer = 0;

    static void dfs(int L, int sum, int[] num) {
        if (L == num.length) {
            if (sum == t) {
                answer++;
            }
            return;
        } else {
            dfs(L + 1, sum + num[L], num);
            dfs(L + 1, sum - num[L], num);
        }
    }
}
