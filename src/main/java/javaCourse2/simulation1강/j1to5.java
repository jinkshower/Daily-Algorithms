package javaCourse2.simulation1강;

import java.util.ArrayList;
import java.util.List;

public class j1to5 {

    //못품. peak를 찾을 생각도 못함
    public int solution(int[] nums) {
        int answer = 0;
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                peaks.add(i);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < peaks.size(); i++) {
            int cur = peaks.get(i);
            int cnt = 1;
            while (cur > 0) {
                if (nums[cur - 1] >= nums[cur]) {
                    break;
                }
                cur--;
                cnt++;
            }
            cur = peaks.get(i);
            while (cur < nums.length - 1) {
                if (nums[cur + 1] >= nums[cur]) {
                    break;
                }
                cur++;
                cnt++;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}
