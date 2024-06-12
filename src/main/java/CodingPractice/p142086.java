package CodingPractice;

public class p142086 {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        char[] chars = s.toCharArray();
        answer[0] = -1;
        for (int i = 1; i < chars.length; i++) {
            for (int j = 0; j < i; j++) {
                if (chars[i] == chars[j]) {
                    answer[i] = i - j;
                }
            }
            if (answer[i] == 0) {
                answer[i] = -1;
            }
        }
        return answer;
    }
}
