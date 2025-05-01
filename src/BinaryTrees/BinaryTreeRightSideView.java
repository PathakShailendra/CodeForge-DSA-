package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightview(root, ans, 0);
        return ans;
    }
    public void rightview(TreeNode curr, List<Integer> ans , int depth){
        if(curr == null){
            return;
        }
        if(depth == ans.size()){
            ans.add(curr.val);
        }
        rightview(curr.right, ans, depth+1);
        rightview(curr.left, ans, depth +1);

    }
}
