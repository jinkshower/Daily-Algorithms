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

    //다시 풀기
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int col = str.charAt(0) - 'a' + 1;
        int row = str.charAt(1) - '0';

        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];

            if (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8) {
                count++;
            }
        }
        System.out.println(count);
    }
}
