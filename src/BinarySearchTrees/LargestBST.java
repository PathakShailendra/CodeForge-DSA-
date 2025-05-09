package BinarySearchTrees;

public class LargestBST {
    static int maxBSTSize;

    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    static Info postOrder(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Info left = postOrder(root.left);
        Info right = postOrder(root.right);

        if (left.isBST && right.isBST && root.data > left.max && root.data < right.min) {
            int size = left.size + right.size + 1;
            maxBSTSize = Math.max(maxBSTSize, size);
            int min = Math.min(root.data, left.min);
            int max = Math.max(root.data, right.max);
            return new Info(true, size, min, max);
        } else {
            return new Info(false, 0, 0, 0);
        }
    }

    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        maxBSTSize = 0;  // reset before running
        postOrder(root);
        return maxBSTSize;
    }
}
