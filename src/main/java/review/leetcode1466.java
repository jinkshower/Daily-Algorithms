package review;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class leetcode1466 {

    public int minReorder(int n, int[][] connections) {
        // make adjacent graph (undirected)
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        Set<String> edges = new HashSet<>();
        for (int[] connection : connections) {
            int a = connection[0];
            int b = connection[1];

            graph.get(a).add(b);
            graph.get(b).add(a);
            edges.add(a + "," + b); //store direction
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        int changes = 0;

        while (!queue.isEmpty()) {
            int city = queue.poll();

            for (int neighbor : graph.get(city)) {
                if (!visited[neighbor]) {
                    // if this connection is outgoing
                    if (edges.contains(city + "," + neighbor)) {
                        changes++;
                    }
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
        //time O(n) space O(n)
        return changes;
    }
}
