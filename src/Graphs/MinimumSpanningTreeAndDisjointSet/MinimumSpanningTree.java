package Graphs.MinimumSpanningTreeAndDisjointSet;

import java.util.List;
import java.util.PriorityQueue;

public class MinimumSpanningTree {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // (weight, node)
        pq.add(new int[]{0, 0}); // Starting from node 0 with weight 0
        int sum = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int wt = current[0];
            int node = current[1];

            if (visited[node]) continue;

            visited[node] = true;
            sum += wt;

            for (int[] neighbor : adj.get(node)) {
                int adjNode = neighbor[0];
                int edgeWt = neighbor[1];
                if (!visited[adjNode]) {
                    pq.add(new int[]{edgeWt, adjNode});
                }
            }
        }

        return sum;
    }
}
