package review;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
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

    public static void levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public static Node insert(Node root, int data) {
        // 1. 현재 루트가 null이면, 새로운 노드를 생성해서 반환
        if (root == null) {
            return new Node(data);
        }

        // 2. 삽입할 데이터가 현재 루트 노드의 데이터보다 작으면
        //    왼쪽 서브트리에 삽입을 시도
        if (root.data > data) {
            root.left = insert(root.left, data);
        }
        // 3. 삽입할 데이터가 현재 루트 노드의 데이터보다 크거나 같으면
        //    오른쪽 서브트리에 삽입을 시도
        else {
            root.right = insert(root.right, data);
        }

        // 4. 변경된 루트를 반환
        return root;
    }

    public static Node lca(Node root, int v1, int v2) {
        // 현재 루트가 null이면 공통 조상이 없으므로 null 반환
        if (root == null) {
            return null;
        }

        // 현재 노드가 v1과 v2보다 큰 경우, 공통 조상은 왼쪽 서브트리에 있다
        if (root.data > v1 && root.data > v2) {
            return lca(root.left, v1, v2);
        }

        // 현재 노드가 v1과 v2보다 작은 경우, 공통 조상은 오른쪽 서브트리에 있다
        if (root.data < v1 && root.data < v2) {
            return lca(root.right, v1, v2);
        }

        // v1과 v2가 현재 노드를 기준으로 양쪽에 있다면 현재 노드가 공통 조상
        return root;
    }

    public static List<Integer> getMax(List<String> operations) {
        // Write your code here
        Deque<Integer> mainStack = new ArrayDeque<>();
        Deque<Integer> maxStack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (String operation : operations) {
            String[] parts = operation.split(" ");
            int type = Integer.parseInt(parts[0]);

            if (type == 1) {
                int value = Integer.parseInt(parts[1]);
                mainStack.offerLast(value);

                if (maxStack.isEmpty() || value >= maxStack.peekLast()) {
                    maxStack.offerLast(value);
                }
            } else if (type == 2) {
                int removed = mainStack.pollLast();

                if (!maxStack.isEmpty() && removed == maxStack.peekLast()) {
                    maxStack.pollLast();
                }
            } else if (type == 3) {
                result.add(maxStack.peekLast());
            }

        }
        return result;
    }

    public static int cookies(int k, List<Integer> A) {
        // Write your code here
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i : A) {
            minHeap.offer(i);
        }
        int count = 0;
        while (minHeap.size() != 1) {
            if (minHeap.peek() >= k) {
                return count;
            }

            int a = minHeap.poll();
            int b = minHeap.poll();
            minHeap.offer(a + 2 * b);
            count++;
        }

        if (minHeap.peek() >= k) {
            return count;
        }
        return -1;
    }

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        // Write your code here
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for (int i : h1) {
            sum1 += i;
        }
        for (int i : h2) {
            sum2 += i;
        }
        for (int i : h3) {
            sum3 += i;
        }

        int i = 0, j = 0, k = 0;

        while (i < h1.size() && j < h2.size() && k < h3.size()) {

            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }

            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= h1.get(i++);
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= h2.get(j++);
            } else if (sum3 >= sum1 && sum3 >= sum2) {
                sum3 -= h3.get(k++);
            }
        }

        return 0;
    }
}
