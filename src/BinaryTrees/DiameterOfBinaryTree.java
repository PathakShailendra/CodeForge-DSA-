package BinaryTrees;

public class DiameterOfBinaryTree {
    int ans = 0;
    public int hd(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = hd(root.left);
        int rh = hd(root.right);
        ans = Math.max(ans, (lh+rh));
        return Math.max(lh, rh)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int h = hd(root);
        return ans;
    }
}
