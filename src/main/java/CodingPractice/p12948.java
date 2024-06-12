package CodingPractice;

public class p12948 {

    public String solution(String phone_number) {
        int threshold = phone_number.length() - 4;
        String placeHolder = "*";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(placeHolder.repeat(threshold)).append(phone_number.substring(threshold));
        return stringBuilder.toString();
    }
}
