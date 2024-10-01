package review;

public class pro84512 {
    static int answer;
    static boolean flag;
    static int count;

    public int solution(String word) {
        char[] moem = new char[]{'A', 'E', 'I', 'O', 'U'};

        recur(0, word, "", moem);
        return answer;
    }


    private void recur(int depth, String goal, String made, char[] chars) {
        if (depth > 5) {
            return;
        }

        if (flag) {
            return;
        }

        if (made.equals(goal)) {
            answer = count;
            flag = true;
            return;
        }
        count++;

        for (int i = 0; i < chars.length; i++) {
            recur(depth + 1, goal, made + chars[i], chars);
        }
    }
}
