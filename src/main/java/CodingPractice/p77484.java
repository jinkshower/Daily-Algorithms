package CodingPractice;

public class p77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero_count = 0;
        int common_count = 0;
        for (int i : lottos) {
            if (i == 0) {
                zero_count++;
                continue;
            }
            for (int j : win_nums) {
                if (i == j) {
                    common_count++;
                }
            }
        }
        return new int[]{decide(zero_count + common_count), decide(common_count)};
    }

    public int decide(int num) {
        return switch (num) {
            case 6 -> 1;
            case 5 -> 2;
            case 4 -> 3;
            case 3 -> 4;
            case 2 -> 5;
            default -> 6;
        };
    }
}
