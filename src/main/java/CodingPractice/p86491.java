package CodingPractice;

public class p86491 {

    public int solution(int[][] sizes) {
        int[][] rectangle = new int[sizes.length][sizes[0].length];
        for (int i = 0; i < sizes.length; i++) {
            rectangle[i][0] = Math.max(sizes[i][0], sizes[i][1]);
            rectangle[i][1] = Math.min(sizes[i][0], sizes[i][1]);
        }

        int ver = rectangle[0][0];
        int hor = rectangle[0][1];
        for (int[] ints : rectangle) {
            if (ver < ints[0]) {
                ver = ints[0];
            }
            if (hor < ints[1]) {
                hor = ints[1];
            }
        }
        return ver * hor;
    }
}
