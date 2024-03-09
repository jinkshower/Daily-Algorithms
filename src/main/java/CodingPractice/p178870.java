package CodingPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p178870 {

    class Node implements Comparable<Node> {

        public int lt, rt;

        Node(int lt, int rt) {
            this.lt = lt;
            this.rt = rt;
        }

        @Override
        public int compareTo(Node o) {
            int oC = o.rt - o.lt;
            int tC = this.rt - this.lt;
            if (oC != tC) {
                return tC - oC;
            } else {
                return this.lt - o.lt;
            }
        }
    }

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int lt = 0;
        int sum = 0;
        List<Node> list = new ArrayList<>();
        for (int rt = 0; rt < sequence.length; rt++) {
            sum += sequence[rt];
            if (sum == k) {
                list.add(new Node(lt, rt));
            } else if (sum > k) {
                while (sum >= k) {
                    sum -= sequence[lt];
                    lt++;
                    if (sum == k) {
                        list.add(new Node(lt, rt));
                    }
                }
            }
        }
        Collections.sort(list);
        answer[0] = list.get(0).lt;
        answer[1] = list.get(0).rt;
        return answer;
    }

    //더 좋은 코드 찾음
    public int[] solution2(int[] sequence, int k) {
        int[] answer = new int[2];
        int lt = 0;
        int rt = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while (rt < sequence.length) {
            sum += sequence[rt];
            while (sum >= k) {
                if (sum == k && (rt - lt) < minLen) {
                    minLen = rt - lt;
                    answer[0] = lt;
                    answer[1] = rt;
                }
                sum -= sequence[lt];
                lt++;
            }
            rt++;
        }
        return answer;
    }
}
