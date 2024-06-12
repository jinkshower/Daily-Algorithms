package ndb;

public class WordCompression {

    //내풀이
    public int solution(String s) {
        int min = Integer.MAX_VALUE;
        //max 단위 : s의 길이
        for (int i = 1; i < s.length() - 1; i++) {
            //i개 단위로 자를때
            int count = 0;
            for (int j = 0; j + i * 2 < s.length(); j += i) {
                String token = s.substring(j, j + i);
                String next = s.substring(j + i, j + i * 2);
                System.out.println("s : " + s);
                System.out.println("token : " + token);
                System.out.println("next : " + next);
                //자른 두개가 같다면 압축
                if (token.equals(next)) {
                    count += 2;
                }
                //아니라면 그냥 증가
                else {
                    count += token.length() + next.length();
                }
                //단위에 따라 남은 개수 증가

                System.out.println("count : " + count);
            }
            System.out.println("--------------------잘림");
            //i개 단위로 잘린 count
            if (count != 0) {
                min = Math.min(min, count);
            }
            System.out.println("min : " + min);
        }
        return min;
    }
}
