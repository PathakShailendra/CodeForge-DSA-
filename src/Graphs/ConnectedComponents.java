package Graphs;

import java.util.*;

public class ConnectedComponents {

    public static void main(String[] args) {
        int n = 7; // Nodes 0 to 6

        // Step 1: Create the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Component 1
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(2).add(0);

        // Component 2
        adj.get(3).add(4);
        adj.get(4).add(3);

        // Component 3
        adj.get(5).add(6);
        adj.get(6).add(5);

        // Step 2: Count connected components
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited);
                count++;
            }
        }

        System.out.println("Total Connected Components: " + count);
    }

    // DFS function
    private static void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}
