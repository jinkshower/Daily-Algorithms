package review;

public class leetcode334 {

    public boolean increasingTriplet(int[] nums) {

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int element : nums) {

            if (first >= element) { // 가장 작은 값이 first에 저장되게 앞에서 수문장 역할
                first = element;
            } else if (second >= element) { // first보다 크고 second보다 작은 값이 second에 저장되게
                second = element;
            } else { // first, second보다 큰 값이 나오면 세번째 값이 존재하는 것
                // third = element;
                return true;
            }
        }

        return false;
    }
}
