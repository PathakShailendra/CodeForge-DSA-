package BinarySearchTrees;

public class CeilInBST {
    public static int ceil(Node root, int x) {
        int ans = -1;

        while (root != null) {
            if (root.data == x) {
                return root.data;
            }

            if (root.data > x) {
                ans = root.data;     // possible ceil
                root = root.left;    // try to find smaller valid value
            } else {
                root = root.right;
            }
        }

        return ans;
    }

}
