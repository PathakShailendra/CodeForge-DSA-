package BinaryTrees;

public class HeightOfBinaryTree {
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int lsh = height(root.left);
        int rsh = height(root.right);
        return Math.max(lsh, rsh)+1;
    }
    public int maxDepth(TreeNode root) {
        return height(root);
    }
}
