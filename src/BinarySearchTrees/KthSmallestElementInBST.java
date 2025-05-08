package BinarySearchTrees;

public class KthSmallestElementInBST {
    int count = 0;
    int ans = -1;
    public void inOrder(TreeNode root, int k){
        if(root == null){
            return;
        }
        inOrder(root.left, k);
        count++;
        if(count == k){
            ans = root.val;
        }
        inOrder(root.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        inOrder(root,k);
        return ans;
    }
}
