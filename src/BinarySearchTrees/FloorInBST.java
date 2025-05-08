package BinarySearchTrees;

public class FloorInBST {
    public static int floor(Node root, int x) {
        // Code here
        int ans = -1;

        while (root != null) {
            if (root.data == x) return root.data;

            if (root.data < x) {
                ans = root.data;
                root = root.right; // try for closer floor
            } else {
                root = root.left;
            }
        }

        return ans;
    }
}
