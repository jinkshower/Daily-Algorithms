package CodingPractice;

public class p181942 {
    public String solution(String str1, String str2) {
        String answer = "";
        char[] charStr1 = str1.toCharArray();
        char[] charStr2 = str2.toCharArray();
        for (int i = 0; i < str1.length(); i++) {
            answer += charStr1[i];
            answer += charStr2[i];
        }
        return answer;
    }
}
