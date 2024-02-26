package javaCourse.RecursiveTreeGraph7강;

import java.util.LinkedList;
import java.util.Queue;

public class j7to7 {

    static class Node {

        int data;
        Node lt, rt;

        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }

    Node root;

    public void BFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) {
                    Q.offer(cur.lt);
                }
                if (cur.rt != null) {
                    Q.offer(cur.rt);
                }
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String args[]) {
        j7to7 tree = new j7to7();
        tree.root = new j7to7.Node(1);
        tree.root.lt = new j7to7.Node(2);
        tree.root.rt = new j7to7.Node(3);
        tree.root.lt.lt = new j7to7.Node(4);
        tree.root.lt.rt = new j7to7.Node(5);
        tree.root.rt.lt = new j7to7.Node(6);
        tree.root.rt.rt = new j7to7.Node(7);
        tree.BFS(tree.root);
    }
}
