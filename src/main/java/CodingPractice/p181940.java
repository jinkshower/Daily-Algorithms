package CodingPractice;

public class p181940 {
    public String solution(String my_string, int k) {
//        String answer = "";
//        for (int i = 0; i < k; i++) {
//            answer += my_string;
//        }
//        return answer;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append(my_string);
        }
        return sb.toString();
    }
}
