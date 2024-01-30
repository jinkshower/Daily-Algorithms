package CodingPractice;

public class p172928 {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        int startOne = 0;
        int startTwo = 0;
        for (int i = 0; i < park.length; i++) {
            if (park[i].contains("S")) {
                startOne = i;
                startTwo = park[i].indexOf("S");
            }
            if (park[i].contains("X")) {

            }
        }
        int parkWidth = park.length;
        int parkHeight = park[0].length();

        int moveOne = 0;
        int moveTwo = 0;

        for (String route : routes) {
            char direction = route.charAt(0);
            int distance = route.charAt(2);
            if (direction == 'E' || direction == 'W') {
                // e , w -> 두번째가 +=
                moveTwo = direction == 'E' ? distance : -distance;
                if (startTwo + moveTwo > parkWidth || startTwo + moveTwo < 0) {
                    break;
                }
                boolean stuck = false;
            } else {
                // s, n -> 첫번째가 +=
                moveOne = direction == 'S' ? distance : -distance;
            }
        }
        return answer;
    }
}
