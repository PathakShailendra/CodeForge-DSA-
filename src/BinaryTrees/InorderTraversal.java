package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode() {}
        TreeNode right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private void inorder(List<Integer> ans, TreeNode root) {
        if(root == null) return;
        inorder(ans, root.left);
        ans.add(root.val);
        inorder(ans, root.right);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(ans, root);
        return ans;
    }
}
