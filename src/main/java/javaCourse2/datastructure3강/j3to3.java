package javaCourse2.datastructure3강;

import java.util.LinkedList;
import java.util.Queue;

public class j3to3 {

    //강의 풀이
    public int[] solution(int[] arrival, int[] state) {
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();
        int n = arrival.length, prev = 1;
        int[] answer = new int[n];

        for (int t = 0, i = 0, cnt = 0; ; t++) {
            if (enter.isEmpty() && exit.isEmpty() && i < n) {
                if (t < arrival[i]) {
                    t = arrival[i];
                    prev = 1;
                }
            }
            while (i < n && arrival[i] <= t) {
                if (state[i] == 0) {
                    enter.offer(i);
                } else {
                    exit.offer(i);
                }
                i++;
            }
            if (prev == 1) {
                if (!exit.isEmpty()) {
                    answer[exit.poll()] = t;
                    prev = 1;
                } else {
                    answer[enter.poll()] = t;
                    prev = 0;
                }
            } else if (prev == 0) {
                if (!enter.isEmpty()) {
                    answer[enter.poll()] = t;
                    prev = 0;
                } else {
                    answer[exit.poll()] = t;
                    prev = 1;
                }
            }
            cnt++;
            if (cnt == n) {
                break;
            }
        }
        return answer;
    }
    //다시 풀어보기
    public int[] solution2(int[] arrival, int[] state){
        Queue<Integer> enter = new LinkedList<>();
        Queue<Integer> exit = new LinkdedList<>();
        int n = arrival.length;
        int prev = 1;
        int[] answer = new int[n];
        //t time
        //i 사원번호
        //cnt 현관문 사용한 사람수
        for (int t = 0; i = 0; cnt = 0; ; t++) {
            //아무도 현관문에 없을때 땡기기
            if (enter.isEmpty() && exit.isEmpty() && i < n) {
                if (t < arrival[i]) {
                    t = arrival[i];
                    prev = 1;
                }
            }
            //q에 넣기
            while (i < n && arrival[i] <= t) {
                if (state[i] == 1) exit.offer(i);
                else (state[i] == 0) enter.offer(i);
                i++;
            }
            //처리
            if (prev == 1) {
                if (!exit.isEmpty()) {
                    answer[exit.poll()] = t;
                    prev = 1;
                }else {
                    answer[enter.poll()] = t;
                    prev = 0;
                }
            } else if (prev == 0) {
                if (!enter.isEmpty()) {
                    answer[enter.poll()] = t;
                    prev = 0;
                } else {
                    answer[exit.poll()] = t;
                    prev = 1;
                }
            }
            cnt++;
            if (cnt == n )break;
        }
        return answer;
    }
}
