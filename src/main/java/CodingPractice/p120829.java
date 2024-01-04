package CodingPractice;

public class p120829 {
    public int solution(int angle) {
//        예각 : 0 < angle < 90
//        직각 : angle = 90
//        둔각 : 90 < angle < 180
//        평각 : angle = 180

        int answer = 0;
        if (0 < angle && angle < 90) {
            answer = 1;
        } else if (angle == 90) {
            answer = 2;
        } else if (90 < angle && angle < 180) {
            answer = 3;
        } else if (angle == 180) {
            answer = 4;
        }
        return answer;
    }
}
