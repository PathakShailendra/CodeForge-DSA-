package Graphs.ShortestPathAlgorithms;

import java.util.*;

public class DijkstraAlgorithmTreeSet {
    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        // Important: comparator for TreeSet
        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (!(obj instanceof Pair)) return false;
            Pair o = (Pair) obj;
            return node == o.node && dist == o.dist;
        }

        @Override
        public int hashCode() {
            return Objects.hash(node, dist);
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        // Step 1: Build adjacency list
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt)); // Remove this if the graph is directed
        }

        // Step 2: Distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 3: TreeSet with comparator based on dist, then node
        TreeSet<Pair> set = new TreeSet<>((a, b) -> {
            if (a.dist != b.dist) return a.dist - b.dist;
            return a.node - b.node;
        });

        set.add(new Pair(src, 0));

        // Step 4: Dijkstra using TreeSet
        while (!set.isEmpty()) {
            Pair current = set.pollFirst(); // smallest dist node
            int u = current.node;

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.dist;

                if (dist[u] + weight < dist[v]) {
                    // Remove the older entry if exists
                    if (dist[v] != Integer.MAX_VALUE) {
                        set.remove(new Pair(v, dist[v]));
                    }

                    dist[v] = dist[u] + weight;
                    set.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }
}
