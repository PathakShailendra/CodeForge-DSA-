package Graphs;

import java.util.*;

public class TopoSortDFS {
    static void topoSort(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(i, adj, visited, stack);
        }

        // Print Topo Order
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    static void dfs(int node, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }
        stack.push(node); // Push after visiting all neighbors
    }

    public static void main(String[] args) {
        int V = 6; // Number of nodes
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Graph: 5 → 2, 5 → 0, 4 → 0, 4 → 1, 2 → 3, 3 → 1
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        topoSort(V, adj);
    }
}
