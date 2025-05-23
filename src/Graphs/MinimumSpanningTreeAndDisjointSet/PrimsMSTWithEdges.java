package Graphs.MinimumSpanningTreeAndDisjointSet;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Triple {
    int weight, node, parent;

    Triple(int weight, int node, int parent) {
        this.weight = weight;
        this.node = node;
        this.parent = parent;
    }
}

public class PrimsMSTWithEdges {

    public static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        boolean[] visited = new boolean[V];
        PriorityQueue<Triple> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Triple(0, 0, -1)); // (weight, node, parent)
        int sum = 0;

        List<int[]> mst = new ArrayList<>(); // to store edges in MST

        while (!pq.isEmpty()) {
            Triple curr = pq.poll();
            int wt = curr.weight;
            int node = curr.node;
            int parent = curr.parent;

            if (visited[node]) continue;

            visited[node] = true;
            sum += wt;

            if (parent != -1) {
                mst.add(new int[]{parent, node});
            }

            for (ArrayList<Integer> neighbor : adj.get(node)) {
                int adjNode = neighbor.get(0);
                int edgeWt = neighbor.get(1);
                if (!visited[adjNode]) {
                    pq.add(new Triple(edgeWt, adjNode, node));
                }
            }
        }

        // (Optional) Print the MST edges
        System.out.println("Edges in MST:");
        for (int[] edge : mst) {
            System.out.println(edge[0] + " - " + edge[1]);
        }

        return sum;
    }
}