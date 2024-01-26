package CodingPractice;

import java.util.*;

public class p150370 {
    public int[] solution(String today, String[] terms, String[] privacies) {

        List<Integer> answerList = new ArrayList<>();
        // split today by dot
        int todayForm = calToday(today);
        System.out.println("todayForm = " + todayForm);

        //store terms
        Map<String, Integer> termsMap = new HashMap<>();
        for (String term : terms) {
            String[] tmp = term.split(" ");
            termsMap.put(tmp[0], Integer.parseInt(tmp[1]));
        }

        //test
        System.out.println(termsMap);

        int[] dateForm = new int[3];

        // loop through privacies
        for (int a = 0; a < privacies.length; a++) {
            // split by blank
            String[] firstSplit = privacies[a].split(" ");
            System.out.println("firstSplit = " + Arrays.toString(firstSplit));
            // make dateform into int array
            String[] secondSplit = firstSplit[0].split("\\.");
            for (int i = 0; i < 3; i++) {
                dateForm[i] = Integer.parseInt(secondSplit[i]);
            }
            System.out.println(Arrays.toString(dateForm));
            // compare fistSplit[1] to termsMap
            int exp = termsMap.get(firstSplit[1]);
            System.out.println("exp = " + exp);
            // calcualte the expiration date
            int expDate = calculateExpDate(dateForm, exp);
            System.out.println("expDate = " + expDate);
            // compare the expdate.with today
            if (todayForm < expDate) {
                // store the index + 1 in answer
                answerList.add(a + 1);
            }
        }


        return answerList.stream().mapToInt(i -> i).toArray();
    }

    private int calToday(String today) {
        String[] split = today.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < split.length; i++) {
            int tmp = Integer.parseInt(split[i]);
            sb.append(tmp);
        }
        return Integer.parseInt(sb.toString());
    }

    public int calculateExpDate(int[] dateForm, int exp) {
        StringBuilder sb = new StringBuilder();
        if (dateForm[1] + exp > 12) {
            sb.append(dateForm[0] + 1);
            sb.append((dateForm[1] + exp) % 12);
            sb.append(dateForm[2]);
        } else {
            sb.append(dateForm[0]).append(dateForm[1] + 6).append(dateForm[2]);
        }
        return Integer.parseInt(sb.toString());
    }
}
