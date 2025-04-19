package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class PostOrderTraversal {
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
    private void postorder(List<Integer> ans, TreeNode root) {
        if(root == null) return;
        postorder(ans, root.left);
        postorder(ans, root.right);
        ans.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(ans, root);
        return ans;
    }
}
