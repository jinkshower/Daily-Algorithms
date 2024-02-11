package ndb;

import java.util.Scanner;

public class Knight {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int row = input.charAt(1) - '0';
        int col = input.charAt(0) - 'a' + 1;

        System.out.println("ver : " + row + " hor : " + col);

        //이동계획
        int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2};
        int[] dy = {-2, 2, -1, 1, 2, 2, 1, -1};

        int count = 0;
        int nx = -1;
        int ny = -1;

        for (int i = 0; i < 8; i++) {
            nx = row + dx[i];
            ny = col + dy[i];
            if (nx < 1 || ny < 1 || nx > 8 || ny > 8) {
                continue;
            }
            count++;
        }
        System.out.println(count);
    }
}
