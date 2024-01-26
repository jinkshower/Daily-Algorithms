package CodingPractice;

import java.util.Arrays;

public class p161990 {
    public int[] solution(String[] wallpaper) {
        int[][] intWall = new int[wallpaper.length][wallpaper[0].length()];
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                intWall[i][j] = wallpaper[i].charAt(j) == '.' ? 0 : 1;
            }
        }
        // drag start dot
        int lux = intWall.length;
        int luy = intWall[0].length;
        // drag end dot
        int rdx = -1;
        int rdy = -1;
        //find out min value of width, length together?
        for (int i = 0; i < intWall.length; i++) {

            //min value of width, length
            //find out max value of wid, len and + 1 (to drag)
            //for every element in intWall
            //refresh each compo
            for (int j = 0; j < intWall[i].length; j++) {
                if (intWall[i][j] == 1) {
                    if (lux > i) {
                        lux = i;
                    }
                    if (luy > j) {
                        luy = j;
                    }
                    if (rdx < i) {
                        rdx = i;
                    }
                    if (rdy < j) {
                        rdy = j;
                    }
                }
            }
        }
        return new int[]{lux, luy, rdx + 1, rdy + 1};
    }

    public static void main(String[] args) {
        p161990 prac = new p161990();
        System.out.println(Arrays.toString(prac.solution(new String[]{"##"})));
    }
}
