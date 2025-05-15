package BinarySearchTrees;

import java.util.ArrayList;

public class PredecessorAndSuccessor {
    Node predecessor = null;
    Node successor = null;

    public ArrayList<Node> findPreSuc(Node root, int key) {
        // Reset predecessor and successor
        predecessor = null;
        successor = null;

        // Call helper
        findPreSucUtil(root, key);

        ArrayList<Node> ans = new ArrayList<>();
        ans.add(predecessor);
        ans.add(successor);
        return ans;
    }

    private void findPreSucUtil(Node root, int key) {
        if (root == null) return;

        if (root.data == key) {
            // Predecessor = rightmost of left subtree
            if (root.left != null) {
                Node temp = root.left;
                while (temp.right != null)
                    temp = temp.right;
                predecessor = temp;
            }

            // Successor = leftmost of right subtree
            if (root.right != null) {
                Node temp = root.right;
                while (temp.left != null)
                    temp = temp.left;
                successor = temp;
            }
        } else if (key < root.data) {
            successor = root;
            findPreSucUtil(root.left, key);
        } else {
            predecessor = root;
            findPreSucUtil(root.right, key);
        }
    }
}
