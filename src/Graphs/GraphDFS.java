package Graphs;

import java.util.*;

public class GraphDFS {

    // DFS Function
    public static void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;  // Number of vertices
        List<List<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges (Undirected Graph)
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(3).add(5);
        adj.get(4).add(2);
        adj.get(4).add(5);
        adj.get(5).add(3);
        adj.get(5).add(4);

        // Visited array
        boolean[] visited = new boolean[V];

        // DFS Traversal from node 0
        System.out.println("DFS Traversal starting from node 0:");
        dfs(0, adj, visited);
    }
}
