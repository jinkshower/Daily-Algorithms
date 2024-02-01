package CodingPractice;

public class p70129 {

    public int[] solution(String s) {
        int[] answer = new int[2];
        int count = 0;
        int zeroCount = 0;

        int before = 0;
        int after = 0;
        while (!s.equals("1")) {
            before = s.length();
            s = s.replaceAll("0", "");
            after = s.length();
            zeroCount += before - after;
            s = Integer.toString(after, 2);
            count++;
        }
        answer[0] = count;
        answer[1] = zeroCount;

        return answer;
    }
}
