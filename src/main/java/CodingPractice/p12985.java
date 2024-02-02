package CodingPractice;

public class p12985 {
    public int solution(int n, int a, int b) {
        int answer = 0;
        while (a != b) {
            a = proceedRound(a);
            b = proceedRound(b);
            answer++;
        }

        return answer;
    }

    public int proceedRound(int num) {
        if (num % 2 == 0) {
            return num / 2;
        } else {
            num++;
            return num / 2;
        }
    }
}
