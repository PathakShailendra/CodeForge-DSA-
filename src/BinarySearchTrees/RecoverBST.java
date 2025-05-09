package BinarySearchTrees;

public class RecoverBST {
    TreeNode first = null, second = null, prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        // Detect swapped nodes
        if (prev.val > root.val) {
            if (first == null) first = prev;
            second = root;
        }

        prev = root;

        inorder(root.right);
    }
}
