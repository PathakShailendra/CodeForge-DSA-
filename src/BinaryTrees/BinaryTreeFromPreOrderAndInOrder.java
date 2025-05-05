package BinaryTrees;

import java.util.HashMap;

public class BinaryTreeFromPreOrderAndInOrder {
    int pre = 0;
    private TreeNode helper(int left, int right, int []preorder, HashMap<Integer, Integer> map){
        if(pre >= preorder.length)return null;
        if(right < left)return null;
        TreeNode root = new TreeNode(preorder[pre]);
        int in = map.get(preorder[pre++]);
        root.left = helper(left, in-1, preorder, map);
        root.right = helper(in+1, right, preorder, map);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)map.put(inorder[i], i);
        return helper(0, preorder.length-1, preorder, map);
    }
}
