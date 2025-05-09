package BinarySearchTrees;

public class InorderSuccessorPredecessorOfBST {
    static Node predecessor = null;
    static Node successor = null;

    public static void findPredecessorSuccessor(Node root, int key) {
        Node current = root;

        while (current != null) {
            if (key < current.data) {
                // This node might be successor
                successor = current;
                current = current.left;
            } else if (key > current.data) {
                // This node might be predecessor
                predecessor = current;
                current = current.right;
            } else {
                // Exact match found
                // Predecessor = rightmost node in left subtree
                if (current.left != null) {
                    Node temp = current.left;
                    while (temp.right != null) {
                        temp = temp.right;
                    }
                    predecessor = temp;
                }

                // Successor = leftmost node in right subtree
                if (current.right != null) {
                    Node temp = current.right;
                    while (temp.left != null) {
                        temp = temp.left;
                    }
                    successor = temp;
                }

                break; // key found
            }
        }
    }
}
