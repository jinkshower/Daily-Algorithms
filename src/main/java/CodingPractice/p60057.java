package CodingPractice;

public class p60057 {

    public int solution(String s) {
        int answer = s.length(); // 압축과 비교될 원래 길이
        //단위를 늘려가면서 확인
        for (int step = 1; step < s.length() / 2 + 1; step++) {
            String compressed = ""; //압축할 문자열
            String prev = s.substring(0, step); //기준 문자열
            int cnt = 1; // 1부터 시작해야함.

            //단위 만큼 전진
            for (int j = step; j < s.length(); j += step) {
                String sub = "";
                //단위 만큼 sub 만들기
                for (int k = j; k < j + step; k++) {
                    if (k < s.length()) {
                        sub += s.charAt(k);
                    }
                }
                //같으면 계속 검사해야함
                if (prev.equals(sub)) {
                    cnt += 1;
                }
                //다르면
                else {
                    //압축된 결과를 저장
                    compressed += (cnt >= 2) ? cnt + prev : prev;
                    //기준 갱신
                    prev = sub;
                    cnt = 1;
                }
            }
            compressed += (cnt >= 2) ? cnt + prev : prev;
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }
}
