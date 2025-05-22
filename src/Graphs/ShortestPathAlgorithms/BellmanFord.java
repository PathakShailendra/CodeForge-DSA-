package Graphs.ShortestPathAlgorithms;

public class BellmanFord {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        int[] dist = new int[V];

        // Step 1: Initialize distances to "infinity" (as Integer.MAX_VALUE)
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        // Step 2: Relax all edges V - 1 times
        for (int i = 0; i < V - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Step 3: Check for negative-weight cycles
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                // Negative cycle found
                return new int[]{-1};
            }
        }

        // Step 4: Replace all Integer.MAX_VALUE with 1e8 (100000000)
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = (int) 1e8;
            }
        }

        return dist;
    }
}
