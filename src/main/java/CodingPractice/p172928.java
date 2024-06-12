package CodingPractice;

public class p172928 {
    public int[] solution(String[] park, String[] routes) {
        int[] start = getStartPosition(park);
        return start;
    }

    private int[] getStartPosition(String[] park) {
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

}
