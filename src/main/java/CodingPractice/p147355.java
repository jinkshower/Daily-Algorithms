package CodingPractice;

public class p147355 {
    public static void main(String[] args) {
        String t = "10203";
        String p = "15";

        int p_length = p.length();
        long p_num = Long.parseLong(p);

        int max = t.length() - p_length;
        int answer = 0;
        for (int i = 0; i <= max; i++) {
            long sliced = Long.parseLong(t.substring(i, i + p_length));
            if (p_num >= sliced) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
