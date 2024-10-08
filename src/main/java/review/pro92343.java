package review;

import java.util.ArrayList;
import java.util.List;

public class pro92343 {

    static List<List<Integer>> graph;
    static int maxSheep = 0;

    public int solution(int[] info, int[][] edges) {
        graph = new ArrayList<>();

        // 그래프 초기화
        for (int i = 0; i < info.length; i++) {
            graph.add(new ArrayList<>());
        }

        // 트리 구성
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        // 탐색 가능한 노드를 저장하는 리스트
        List<Integer> path = new ArrayList<>();
        path.add(0);  // 루트 노드부터 시작

        // 백트래킹 탐색
        backtrack(0, 0, 0, path, info);

        return maxSheep;
    }

    private void backtrack(int cur, int sheep, int wolf, List<Integer> path, int[] info) {
        // 현재 노드에서 양/늑대 카운트 갱신
        if (info[cur] == 0) {
            sheep++;
        } else {
            wolf++;
        }

        // 늑대가 양의 수보다 많아지면 해당 경로는 유효하지 않음
        if (wolf >= sheep) {
            return;
        }
        // 최대 양 수 갱신
        maxSheep = Math.max(maxSheep, sheep);

        //그래프 탐색 방법이 아예 다름
        //일반적인 백트래킹일 경우 한직선으로 가고 멈춰버림. 이 문제는 경로를 보존해놔야함.
        //[0] -> nextnodes[1,8]이 되고 1을 탐색할 때 nextNodes에 [8]이 남아있음. 즉 sheep을 보존하면서 늑대가 같은 수인 가지만
        //return하는것. sheep을 보존하는 경로를 보존해놓고 가능한 경로를 모두 탐색하는 것

        // 현재 경로에서 이동 가능한 모든 자식 노드 탐색
        List<Integer> nextNodes = new ArrayList<>(path);
        nextNodes.remove(Integer.valueOf(cur));  // 현재 노드를 제거

        // 현재 노드의 자식 노드를 추가
        for (int next : graph.get(cur)) {
            if (!path.contains(next)) {
                nextNodes.add(next);
            }
        }

        // 가능한 모든 경로 탐색
        for (int nextNode : nextNodes) {
            backtrack(nextNode, sheep, wolf, nextNodes, info);
        }
    }
}
