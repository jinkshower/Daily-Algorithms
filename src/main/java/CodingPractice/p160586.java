package CodingPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class p160586 {
    public int[] solution(String[] keymap, String[] targets) {
        List<Integer> match = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < targets.length; i++) {
            //loop through each target
            int keyStroke = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                //for each target, loop through each key and find the index of target[i].charAt(j)
                for (String key : keymap) {
                    int index = key.indexOf(targets[i].charAt(j)); // first key's index of first target's first digit
                    if (index != -1) {  //index is not -1 and index should be the min of each index of keys
                        tmp.add(index + 1); // 0 index means 1 key stroke
                    }
                }
                //tmp contains all the key index of "ABCD"'s "A" without -1
                //i == 0, j == 0 ->  tmp = {2, 3} i should increment 2 and increment j
                if (tmp.isEmpty()) {  //I loop through all the keys but all was -1(not found) it means i can't complete this target
                    keyStroke = -1;
                    break;
                }
                //if is not empty(), increment it
                keyStroke += Collections.min(tmp);
                tmp.clear(); // empty the tmp
            }
            //if min of index is found, add it.
            match.add(keyStroke);
        }
        return match.stream().mapToInt(i -> i).toArray();
    }
}
