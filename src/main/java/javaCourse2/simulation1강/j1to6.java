package javaCourse2.simulation1강;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class j1to6 {

    //9:05 - 9:45 내풀이
    class Student {

        public int min, idx;

        Student(int min, int idx) {
            this.min = min;
            this.idx = idx;
        }
    }

    public int solution(int[][] fruit) {
        int answer = 0;
        //최솟값과 인덱스 저장
        List<Student> list = new ArrayList<>();
        for (int[] f : fruit) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int i = 0; i < f.length; i++) {
                if (f[i] < min) {
                    min = f[i];
                    idx = i;
                }
            }
            list.add(new Student(min, idx));
        }
        int[] ch = new int[fruit.length];
        //교환할 학생 찾기
        for (int i = 0; i < list.size(); i++) {
            Student cur = list.get(i);
            Student next = null;
            int j = i + 1;
            for (; j < list.size(); j++) {
                if (cur.idx != list.get(j).idx && ch[i] == 0 && ch[j] == 0) {
                    next = list.get(j);
                    break;
                }
            }

            if (next == null) {
                continue;
            }
            //교환이 양쪽에게 이득인지 확인
            int[] curFruit = fruit[i];
            int[] nextFruit = fruit[j];
            // System.out.println(Arrays.toString(curFruit));
            // System.out.println(Arrays.toString(nextFruit));
            if (isBene(curFruit, nextFruit, cur, next)) {
                cur.min += 1;
                next.min += 1;
            }
            ch[i] = 1;
            ch[j] = 1;
        }

        for (Student s : list) {
            answer += s.min;
        }
        return answer;
    }

    public boolean isBene(int[] curFruit, int[] nextFruit, Student cur, Student next) {
        // int curMin = cur.min;
        int curIdx = cur.idx;
        // int nextMin = next.min;
        int nextIdx = next.idx;
        curFruit[curIdx] += 1;
        curFruit[nextIdx] -= 1;
        nextFruit[next.idx] += 1;
        nextFruit[curIdx] -= 1;

        int curMinAfter = Arrays.stream(curFruit).min().getAsInt();
        int nextMinAfter = Arrays.stream(nextFruit).min().getAsInt();
        if (cur.min < curMinAfter && next.min < nextMinAfter) {
            return true;
        }
        return false;
    }

    //강의 풀이
    public int getMin(int[] fruit) {
        int min = 100;
        for (int x : fruit) {
            min = Math.min(min, x);
        }
        return min;
    }

    public boolean isMinUnique(int[] fruit) {
        int cnt = 0;
        int min = getMin(fruit);
        for (int x : fruit) {
            if (x == min) {
                cnt++;
            }
        }
        return cnt == 1;
    }

    public int getMinIdx(int[] fruit) {
        int min = getMin(fruit);
        for (int i = 0; i < 3; i++) {
            if (fruit[i] == min) {
                return i;
            }
        }
        return 0;
    }

    public int solution2(int[][] fruit) {
        int answer = 0;
        int[] ch = new int[fruit.length];
        for (int i = 0; i < fruit.length; i++) {

            if (ch[i] == 1) {
                continue;
            }
            if (!isMinUnique(fruit[i])) {
                continue;
            }

            for (int j = i + 1; j < fruit.length; j++) {
                if (ch[j] == 1) {
                    continue;
                }
                if (!isMinUnique(fruit[j])) {
                    continue;
                }

                int a = getMinIdx(fruit[i]);
                int b = getMinIdx(fruit[j]);
                if (a != b && fruit[i][b] > 0 && fruit[j][a] > 0) {
                    if (fruit[i][a] + 1 <= fruit[i][b] - 1 && fruit[j][b] + 1 <= fruit[j][a] - 1) {
                        fruit[i][a]++;
                        fruit[i][b]--;
                        fruit[j][b]++;
                        fruit[j][a]--;
                        ch[i] = 1;
                        ch[j] = 1;
                        break;
                    }
                }
            }
        }
        for (int[] x : fruit) {
            answer += getMin(x);
        }
        return answer;
    }
}
