package BinaryTrees;

import java.util.ArrayList;
import java.util.List;


//
//✅ Morris Trick:
//For every node, we check if it has a left child.
//
//If it does, we find its inorder predecessor (i.e., the rightmost node in the left subtree).
//
//Then we temporarily make the predecessor's right pointer point to the current node.
//
//Move to the left child.
//
//If it doesn’t, then:
//
//Visit the node.
//
//Move to the right child.
//
//If we come back to a node via the temporary right pointer we created earlier, we:
//
//Remove that temporary link.
//
//Visit the node.
//
//Move to the right child.
//
//So we’re building temporary "threads" in the tree to avoid using a stack.
//
//        🧭 Step-by-step Process
//For a node curr:
//
//If curr.left == null:
//
//Visit curr.
//
//Move to curr.right.
//
//        Else:
//
//Find the inorder predecessor of curr.
//
//If pre.right == null:
//
//Set pre.right = curr (create thread).
//
//Move to curr.left.
//
//        Else:
//
//Revert pre.right = null (remove thread).
//
//Visit curr.
//
//Move to curr.right.
//

public class MorrisInOrderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    pre.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return result;
    }
}

