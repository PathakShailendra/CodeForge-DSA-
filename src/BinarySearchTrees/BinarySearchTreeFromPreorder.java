package BinarySearchTrees;

public class BinarySearchTreeFromPreorder {
    int index = 0;

    private TreeNode helper(int[] pre, int bound) {
        if(index == pre.length || pre[index] > bound) {
            return null;
        }
        int val = pre[index++];
        TreeNode root = new TreeNode(val);

        root.left = helper(pre, val);
        root.right = helper(pre, bound);

        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, Integer.MAX_VALUE);
    }
}
