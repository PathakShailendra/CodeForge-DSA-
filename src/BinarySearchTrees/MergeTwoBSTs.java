package BinarySearchTrees;

import java.util.ArrayList;

public class MergeTwoBSTs {
    public ArrayList<Integer> merge(Node root1, Node root2) {
        // Write your code here
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        // Get inorder traversal of both BSTs
        inorder(root1, list1);
        inorder(root2, list2);

        // Merge two sorted lists
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                result.add(list1.get(i++));
            } else {
                result.add(list2.get(j++));
            }
        }

        // Add remaining elements
        while (i < list1.size()) result.add(list1.get(i++));
        while (j < list2.size()) result.add(list2.get(j++));

        return result;

    }

    private void inorder(Node root, ArrayList<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }
}
