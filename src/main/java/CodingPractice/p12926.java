package CodingPractice;

public class p12926 {

    public String solution(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();

        for (char aChar : chars) {
            if (aChar == ' ') {
                stringBuilder.append(aChar);
            } else if (65 <= aChar && aChar <= 90) {
                if (aChar + n > 90) {
                    int k = aChar + n - 91;
                    char c = (char) (65 + k);
                    stringBuilder.append(c);
                } else {
                    char c = (char) (aChar + n);
                    stringBuilder.append(c);
                }
            } else if (97 <= aChar && aChar <= 122) {
                if (aChar + n > 122) {
                    int k = aChar + n - 123;
                    char c = (char) (97 + k);
                    stringBuilder.append(c);
                } else {
                    char c = (char) (aChar + n);
                    stringBuilder.append(c);
                }
            }
        }

        return stringBuilder.toString();
    }
}
