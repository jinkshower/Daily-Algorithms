package CodingPractice;

public class p155652 {
    public String solution(String s, String skip, int index) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();

        for (char c : chars) {
            char tmp = c;
            int tmpIndex = index;
            for (int i = 0; i < tmpIndex; i++) {
                tmp += (char) 1;
                if (tmp == '{') {
                    tmp = 'a';
                }
                if (skip.indexOf(tmp) != -1) {
                    tmpIndex++;
                }
            }
            stringBuilder.append(tmp);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        char tmp = (char) ('z' + 1);

        System.out.println(tmp);
    }

}
