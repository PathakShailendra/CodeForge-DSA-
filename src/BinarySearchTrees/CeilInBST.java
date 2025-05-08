package BinarySearchTrees;

public class CeilInBST {
    private int ceil = -1;

    public void helper(Node root, int x) {
        if(root == null) return;
        if(root.data == x) {
            ceil = root.data;
            return;
        }
        if(root.data > x) {
            ceil = root.data;
            helper(root.left, x);
        } else {
            helper(root.right, x);
        }
    }


    int findCeil(Node root, int key) {
        if (root == null) return -1;
        // Code here
        helper(root, key);
        return ceil;
    }
}
