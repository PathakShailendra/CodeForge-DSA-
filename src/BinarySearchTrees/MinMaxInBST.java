package BinarySearchTrees;

public class MinMaxInBST {

    // Min value of binary search tree
    int minValue(Node root) {
        // code here
        if(root == null) return -1;
        Node curr = root;
        while(curr.left != null) {
            curr = curr.left;
        }
        return curr.data;
    }

    // Max value of binary search tree
    int maxValue(Node root) {
        // code here
        if(root == null) return -1;
        Node curr = root;
        while(curr.right != null) {
            curr = curr.right;
        }
        return curr.data;
    }
}
