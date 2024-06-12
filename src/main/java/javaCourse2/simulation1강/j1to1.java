package javaCourse2.simulation1강;

public class j1to1 {

    //내풀이 09:47-10:06
    public char[] solution(int n, int[][] ladder) {
        char[] answer = new char[n];
        char[] start = new char[n];
        for (int i = 0; i < n; i++) {
            start[i] = (char) ('A' + i);
        }

        for (int i = 0; i < n; i++) {
            char cur = start[i];
            int place = i + 1;
            for (int[] lad : ladder) {
                //각 사다리 숫자에서 왼쪽갈지 오른쪽갈지 판단
                for (int j = 0; j < lad.length; j++) {
                    int left = lad[j];
                    int right = lad[j] + 1;
                    if (place == left) {
                        place++;
                    } else if (place == right) {
                        place--;
                    }
                }
            }
            answer[place - 1] = cur;
        }

        return answer;
    }

    //강의 풀이
    public char[] solution2(int n, int[][] ladder) {
        char[] answer = new char[n];
        char[] start = new char[n];
        for (int i = 0; i < n; i++) {
            start[i] = (char) ('A' + i);
        }

        for (int[] lad : ladder) {
            for (int i = 0; i < lad.length; i++) {
                int cur = lad[i] - 1;
                char tmp = ' ';
                tmp = start[cur];
                start[cur] = start[cur + 1];
                start[cur + 1] = tmp;
            }
        }

        return start;
    }
}
