package BinaryTrees;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerialiseAndDeserialiseBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }
}
