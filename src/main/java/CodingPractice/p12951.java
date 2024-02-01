package CodingPractice;

public class p12951 {
    public String solution(String s) {
        String[] split = s.toLowerCase().split("");

        boolean isFirst = true;
        StringBuilder sb = new StringBuilder();

        for (String token : split) {
            sb.append(isFirst ? token.toUpperCase() : token);
            isFirst = token.equals(" ") ? true : false;
        }
        return sb.toString();
    }
}
