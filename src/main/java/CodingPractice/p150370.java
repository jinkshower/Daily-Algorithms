package CodingPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class p150370 {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] tmp = term.split(" ");
            termMap.put(tmp[0], Integer.parseInt(tmp[1]));
        }

        List<Integer> stopList = new ArrayList<>();
        String[] todayArr = today.split("\\.");

        int todayInt = Integer.parseInt(todayArr[0]) * 12 * 28 +
                Integer.parseInt(todayArr[1]) * 28 + Integer.parseInt(todayArr[2]);

        for (int i = 0; i < privacies.length; i++) {
            String[] tmp = privacies[i].split(" ");
            String[] date = tmp[0].split("\\.");

            int month = Integer.parseInt(date[1]) + termMap.get(tmp[1]);
            int year = Integer.parseInt(date[0]);
            int day = Integer.parseInt(date[2]);

            int updateDate = (year * 12 * 28) + (month * 28) + day;
            if (updateDate <= todayInt) {
                stopList.add(i + 1);
            }
        }

        return stopList.stream().mapToInt(Integer::intValue).toArray();
    }
//
//    public int[] mine(String today, String[] terms, String[] privacies) {
//
//        List<Integer> answerList = new ArrayList<>();
//        // split today by dot
//        int todayForm = calToday(today);
//        System.out.println("todayForm = " + todayForm);
//
//        //store terms
//        Map<String, Integer> termsMap = new HashMap<>();
//        for (String term : terms) {
//            String[] tmp = term.split(" ");
//            termsMap.put(tmp[0], Integer.parseInt(tmp[1]));
//        }
//
//        //test
//        System.out.println(termsMap);
//
//        int[] dateForm = new int[3];
//
//        // loop through privacies
//        for (int a = 0; a < privacies.length; a++) {
//            // split by blank
//            String[] firstSplit = privacies[a].split(" ");
//            System.out.println("firstSplit = " + Arrays.toString(firstSplit));
//            // make dateform into int array
//            String[] secondSplit = firstSplit[0].split("\\.");
//            for (int i = 0; i < 3; i++) {
//                dateForm[i] = Integer.parseInt(secondSplit[i]);
//            }
//            System.out.println(Arrays.toString(dateForm));
//            // compare fistSplit[1] to termsMap
//            int exp = termsMap.get(firstSplit[1]);
//            System.out.println("exp = " + exp);
//            // calcualte the expiration date
//            int expDate = calculateExpDate(dateForm, exp);
//            System.out.println("expDate = " + expDate);
//            // compare the expdate.with today
//            if (todayForm < expDate) {
//                // store the index + 1 in answer
//                answerList.add(a + 1);
//            }
//        }
//
//
//        return answerList.stream().mapToInt(i -> i).toArray();
//    }
}


