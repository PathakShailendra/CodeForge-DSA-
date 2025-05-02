package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    private void backtrack(TreeNode root, List<String> ans, String curr) {
        if(root.left == null && root.right == null) {
            ans.add(curr+root.val);
        }
        if(root.left != null) {
            backtrack(root.left, ans, curr+root.val+"->");
        }
        if(root.right != null) {
            backtrack(root.right, ans, curr+root.val+"->");
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        String rootVal = String.valueOf(root.val);
        backtrack(root, ans, "");
        return ans;
    }
}
