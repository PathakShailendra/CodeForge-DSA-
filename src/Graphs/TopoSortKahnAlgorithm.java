package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopoSortKahnAlgorithm {
    static void kahnTopoSort(int V, List<List<Integer>> adj) {
        int[] inDegree = new int[V];

        // Step 1: Calculate in-degrees
        for (int u = 0; u < V; u++) {
            for (int v : adj.get(u)) {
                inDegree[v]++;
            }
        }

        // Step 2: Add all nodes with in-degree 0 to queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 3: Process the queue
        List<Integer> topoOrder = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topoOrder.add(node);

            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // Check for cycle
        if (topoOrder.size() != V) {
            System.out.println("Cycle detected! Topo sort not possible.");
        } else {
            System.out.println("Topological Sort (Kahn's Algorithm):");
            for (int node : topoOrder) {
                System.out.print(node + " ");
            }
        }
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        kahnTopoSort(V, adj);
    }
}
