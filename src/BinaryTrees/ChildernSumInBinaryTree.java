package BinaryTrees;

public class ChildernSumInBinaryTree {
    static boolean flag = true;

    public static int dfs(Node root) {
        if (root == null) return 0;


        if (root.left == null && root.right == null)
            return root.data;


        int left = dfs(root.left);
        int right = dfs(root.right);


        if (root.data != left + right)
            flag = false;


        return root.data;
    }

    public static int isSumProperty(Node root) {
        flag = true;
        dfs(root);
        return flag ? 1 : 0;
    }
}
