package CodingPractice;

public class p140108 {
    public int solution(String s) {
        int answer = 0;

        char[] chars = s.toCharArray();
        int xCount = 1;
        int yCount = 0;
        char origin = chars[0];
        for (int i = 0; i < chars.length - 1; i++) {
            if (origin == chars[i + 1]) {
                xCount++;
            } else {
                yCount++;
            }
            if (xCount == yCount) {
                answer++;
                xCount = 1;
                yCount = 0;
                chars = s.substring(i + 1).toCharArray();
                origin = chars[0];
            }
        }
        return answer;
    }
}
