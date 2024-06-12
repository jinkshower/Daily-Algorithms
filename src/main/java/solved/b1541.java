package solved;

import java.util.Scanner;

public class b1541 {

    //다시풀기
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        //-를 기준으로 나눔
        String[] minusS = str.split("-");

        int sum = 0;

        for (int i = 0; i < minusS.length; i++) {
            // +값을 저장하기 위한 변수
            int tmpSum = 0;
            //각 token 마다
            String current = minusS[i];
            //+ 를 기준으로 나눔
            String[] plusS = current.split("\\+");
            //+로 나뉘어지면 모두 더함
            for (int j = 0; j < plusS.length; j++) {
                tmpSum += Integer.parseInt(plusS[j]);
            }
            if (i == 0) {
                sum += tmpSum;
            } else {
                sum -= tmpSum;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int sum = Integer.MAX_VALUE;    // 초기 상태 여부 확인을 위한 값으로 설정
        String[] subtraction = in.nextLine().split("-");

        for (int i = 0; i < subtraction.length; i++) {
            int temp = 0;

            // 뺄셈으로 나뉜 토큰을 덧셈으로 분리하여 해당 토큰들을 더한다.
            String[] addition = subtraction[i].split("\\+");

            // 덧셈으로 나뉜 토큰들을 모두 더한다.
            for (int j = 0; j < addition.length; j++) {
                temp += Integer.parseInt(addition[j]);
            }

            // 첫 번째토큰인 경우 temp값이 첫 번째 수가 됨
            if (sum == Integer.MAX_VALUE) {
                sum = temp;
            } else {
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}
