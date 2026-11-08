package week9;

class BinsearchInsertion {
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

    public static Node binsearchInsertion(Node root, int data) {
        // Neu cay rong hoac da den vi tri can them
        if (root == null) {
            return new Node(data);
        }

        // Neu data nho hon nut hien tai, chen vao cay con trai
        if (data < root.data) {
            root.left = binsearchInsertion(root.left, data);
        }
        // Neu data lon hon nut hien tai, chen vao cay con phai
        else if (data > root.data) {
            root.right = binsearchInsertion(root.right, data);
        }
        // Neu data bang nut hien tai thi khong chen lai
        return root;
    }
}