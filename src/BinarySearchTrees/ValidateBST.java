package BinarySearchTrees;

public class ValidateBST {
    public boolean isBST(TreeNode root, long minval, long maxval){
        if(root == null)return true;
        if(root.val <= minval || root.val >= maxval)return false;
        return isBST(root.left,minval,root.val) && isBST(root.right,root.val,maxval);
    }

    public boolean isValidBST(TreeNode root) {
        return isBST(root,Long.MIN_VALUE,Long.MAX_VALUE);

    }
}
