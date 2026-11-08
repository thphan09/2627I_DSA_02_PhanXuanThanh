package week9;

public class binsertTreeLowestCommonAncestor {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else if (data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static Node lca(Node root, int v1, int v2) {
        if (root == null) {
            return null;
        }

        if (v1 > root.data && v2 > root.data) {
            return lca(root.right, v1, v2);
        }

        if (v1 < root.data && v2 < root.data) {
            return lca(root.left, v1, v2);
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = null;
        int[] values = {5, 2, 8, 1, 3, 7, 9, 6};

        for (int value : values) {
            root = insert(root, value);
        }

        System.out.println(lca(root, 2, 6).data);
    }
}
