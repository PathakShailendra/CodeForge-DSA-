package Graphs.ShortestPathAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDAG {
    static class Pair {
        int node, weight;
        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Step 1: Build the adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        // Step 2: Topological sort using DFS
        boolean[] visited = new boolean[V];
        Stack<Integer> topoStack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                dfs(i, adj, visited, topoStack);
        }

        // Step 3: Initialize distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;  // distance to source is 0

        // Step 4: Process nodes in topological order
        while (!topoStack.isEmpty()) {
            int u = topoStack.pop();
            if (dist[u] != Integer.MAX_VALUE) {
                for (Pair neighbor : adj.get(u)) {
                    if (dist[u] + neighbor.weight < dist[neighbor.node]) {
                        dist[neighbor.node] = dist[u] + neighbor.weight;
                    }
                }
            }
        }

        // Step 5: Replace unreachable distances with -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }

    private void dfs(int node, List<List<Pair>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[node] = true;
        for (Pair neighbor : adj.get(node)) {
            if (!visited[neighbor.node]) {
                dfs(neighbor.node, adj, visited, stack);
            }
        }
        stack.push(node);
    }
}
