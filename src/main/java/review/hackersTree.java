package review;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class hackersTree {
    public static void preOrder(Node root) {
        System.out.print(root.data + " ");
        if (root.left != null) {
            preOrder(root.left);
        }
        if (root.right != null) {
            preOrder(root.right);
        }
    }

    public static void postOrder(Node root) {
        if (root.left != null) {
            postOrder(root.left);
        }
        if (root.right != null) {
            postOrder(root.right);
        }
        System.out.print(root.data + " ");
    }

    public static void inOrder(Node root) {
        if (root.left != null) {
            inOrder(root.left);
        }
        System.out.print(root.data + " ");
        if (root.right != null) {
            inOrder(root.right);
        }
    }

    public static int height(Node root) {
        // Write your code here.
        if (root == null) {
            return -1;// 간선의 개수이므로. 노드의 개수라면 0을 리턴해야함.
        }

        int leftCount = height(root.left);
        int rightCount = height(root.right);

        return Math.max(leftCount, rightCount) + 1;
    }

    public static void topView(Node root) {
        if (root == null) {
            return;
        }
        //for print, sort values by key
        Map<Integer, Integer> topViews = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node currentNode = current.node;
            int distance = current.distance;

            if (!topViews.containsKey(distance)) {
                topViews.put(distance, currentNode.data);
            }

            if (currentNode.left != null) {
                queue.offer(new Pair(currentNode.left, distance - 1));
            }

            if (currentNode.right != null) {
                queue.offer(new Pair(currentNode.right, distance + 1));
            }
        }

        for (int value : topViews.values()) {
            System.out.print(value + " ");
        }
    }

    static class Pair {
        Node node;
        int distance;

        Pair(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
