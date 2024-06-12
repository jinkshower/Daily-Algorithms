package CodingPractice;

import java.util.HashMap;
import java.util.Map;

public class p178871 {
    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> playerMap = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            playerMap.put(players[i], i);
        }

        int calledIndex = 0;
        for (String calling : callings) {
            //update playerMap by each calling
            //called key's value -1, -1ed key's value +1
            calledIndex = playerMap.get(calling);
            String overtaken = players[calledIndex - 1];

            playerMap.replace(overtaken, calledIndex);
            players[calledIndex] = overtaken;

            playerMap.replace(calling, calledIndex - 1);
            players[calledIndex - 1] = calling;
        }


        // // for every elements in callings
        // for (int i = 0; i < callings.length; i++) {
        //     //if mumu is called,
        //     //find the index of mumu, i
        //     for (int j = 0; j < players.length; j++) {
        //         if (callings[i].equals(players[j])) {
        //             calledIndex = j;
        //         }
        //     }
        //     //swap players[i] with playrs[i -1]
        //     tmp = players[calledIndex];
        //     players[calledIndex] = players[calledIndex - 1];
        //     players[calledIndex - 1] = tmp;
        // }
        // return players;
        return players;
    }
}
