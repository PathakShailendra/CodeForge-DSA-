package Graphs.ShortestPathAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraAlgorithmPriorityQueue {
    static class Pair {
        int node;
        int dist;

        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt)); // remove this if the graph is directed
        }

        // Step 2: Initialize distance array
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Step 3: PriorityQueue with custom comparator
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> {
            if (a.dist != b.dist) return a.dist - b.dist;
            return a.node - b.node;
        });

        pq.add(new Pair(src, 0));

        // Step 4: Process the queue
        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            int d = current.dist;

            for (Pair neighbor : adj.get(u)) {
                int v = neighbor.node;
                int weight = neighbor.dist;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        return dist;
    }
}
