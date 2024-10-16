package review;

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
}
