package solved;

import java.util.Scanner;

public class b1074 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        int result = 0;
        int s = z(n, x, y, result);
        System.out.println(s);
    }

    public static int z(int n, int x, int y, int result) {

        if (n == 0) {
            return result;
        }

        int half = (int) Math.pow(2, n - 1);
        int quad;

        if (x >= half && y >= half) {
            quad = 3;
            x -= half;
            y -= half;
        } else if (x < half && y >= half) {
            quad = 2;
            y -= half;
        } else if (x >= half && y < half) {
            quad = 1;
            x -= half;
        } else {
            quad = 0;
        }

        int initNum = (int) Math.pow(4, n - 1);
        result += (initNum * quad);

        return z(--n, x, y, result);
    }
}
