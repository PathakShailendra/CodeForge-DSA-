package BinarySearchTrees;

public class DeleteNodeInBST {
    public TreeNode findIS(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return null;
        if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        else if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else{
            if(root.left == null && root.right == null){
                return null;
            }

            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            TreeNode IS = findIS(root.right);
            root.val = IS.val;
            root.right = deleteNode(root.right, IS.val);
        }
        return root;
    }
}
