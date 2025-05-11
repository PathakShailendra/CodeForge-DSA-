package Graphs;

import java.util.List;

public class DetectCycleInUndirectedGraphDFS {
    public boolean detectCycle(int V, List<List<Integer>> adj) {
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, -1, visited, adj)) {
                    return true; // Cycle found
                }
            }
        }

        return false; // No cycle
    }

    private boolean dfs(int node, int parent, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, node, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true; // Cycle found
            }
        }

        return false; // No cycle from this node
    }
}
