package BinaryTrees;

import java.util.*;

public class BurningTree {
    static Node key = null;
    private static void buildParentMap(Node node, Node parent, Map<Node, Node> map, int target) {
        if (node == null) return;

        map.put(node, parent);
        if(node.data == target) {
            key = node;
        }
        buildParentMap(node.left, node, map, target);
        buildParentMap(node.right, node, map, target);
    }

    public static int minTime(Node root, int target) {
        // code here
        Map<Node, Node> parentMap = new HashMap<>();
        buildParentMap(root, null, parentMap, target);

        Set<Node> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(key);
        visited.add(key);

        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (node.left != null && !visited.contains(node.left)) {
                    queue.offer(node.left);
                    visited.add(node.left);
                }

                if (node.right != null && !visited.contains(node.right)) {
                    queue.offer(node.right);
                    visited.add(node.right);
                }

                Node parent = parentMap.get(node);
                if (parent != null && !visited.contains(parent)) {
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
            time++;
        }
        return time-1;
    }
}
