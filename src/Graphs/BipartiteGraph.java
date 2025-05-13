package Graphs;

import java.util.*;

public class BipartiteGraph {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u); // Since it's an undirected graph
        }

        // Step 2: Initialize color array
        int[] color = new int[V];
        Arrays.fill(color, -1);

        // Step 3: For disconnected components
        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(i, adj, color))
                    return false;
            }
        }

        return true;
    }

    private boolean bfsCheck(int start, List<List<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : adj.get(node)) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    q.offer(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }
}
