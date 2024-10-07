package review;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class happyflower {
    static class Node {
        int initial;

        Node(int initial) {
            this.initial = initial;
        }
    }

    private static int[] happyFlowers(int[] emotions, int[] orders) {
        int[] result = new int[orders.length];
        // 여기서 key는 식물의 감정 상태. 즉 2라면 2의 감정을 가지고 있는 식물들의 Set
        // keymap은 map에 식물이 어디 있는 지 기록하는 것.
        // nodes는 node를 빠르게 빼고 꺼내기 위한 배열
        Map<Integer, Set<Node>> map = new HashMap<>();
        Map<Node, Integer> keyMap = new HashMap<>();
        Node[] nodes = new Node[emotions.length + 1];

        for (int i = 0; i < emotions.length; i++) {
            Node node = new Node(emotions[i]);
            map.putIfAbsent(emotions[i], new HashSet<>());
            map.get(emotions[i]).add(node);

            keyMap.put(node, emotions[i]);
            nodes[i + 1] = node;
        }

        int deadThreshold = 1;
        for (int o : orders) {
            if (keyMap.containsKey(nodes[o])) { //죽은 건 제거하니까 contains필요
                Node node = nodes[o]; //node를 가져옴
                int nodeIdx = keyMap.get(node); // 현재 상태를 idx로 가져옴
                map.get(nodeIdx).remove(node); // 현재 상태에서 제거

                int nextIdx = nodeIdx + node.initial;
                //nodeIdx = 1nextIdx = 2 1일 더 생존할 수 있음
                keyMap.put(node, nextIdx);
                map.putIfAbsent(nextIdx, new HashSet<>());
                map.get(nextIdx).add(node);
            }

            if (map.containsKey(deadThreshold)) {
                for (Node n : map.get(deadThreshold)) {
                    keyMap.remove(n);
                }
                map.remove(deadThreshold);
            }

            result[deadThreshold - 1] = keyMap.size();
            deadThreshold++;
        }

        return result;
    }
}
