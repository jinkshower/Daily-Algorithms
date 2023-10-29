package CodingPractice;

public class p181928 {
    public int solution(int[] num_list) {
        StringBuilder oddSb = new StringBuilder();
        StringBuilder evenSb = new StringBuilder();
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] % 2 == 1) {
                oddSb.append(String.valueOf(num_list[i]));
            } else {
                evenSb.append(String.valueOf(num_list[i]));
            }
        }
        return Integer.parseInt(String.valueOf(oddSb)) + Integer.parseInt(String.valueOf(evenSb));
    }
}
