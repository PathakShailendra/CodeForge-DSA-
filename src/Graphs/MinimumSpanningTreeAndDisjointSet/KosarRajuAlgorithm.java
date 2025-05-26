package Graphs.MinimumSpanningTreeAndDisjointSet;

import java.util.ArrayList;
import java.util.Stack;

public class KosarRajuAlgorithm {
    private void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st) {
        vis[node] = 1;
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                dfs(it, vis, adj, st);
            }
        }
        st.push(node);
    }

    // Second DFS on the transposed graph
    private void dfs3(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = 1;
        for (Integer it : adjT.get(node)) {
            if (vis[it] == 0) {
                dfs3(it, vis, adjT);
            }
        }
    }
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        // code here
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();

        // Step 1: Fill stack with vertices in the order of completion time
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, adj, st);
            }
        }

        // Step 2: Transpose the graph
        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            vis[i] = 0; // Reset visited for 2nd DFS
            for (Integer it : adj.get(i)) {
                adjT.get(it).add(i); // Reverse edge
            }
        }

        // Step 3: Do DFS based on finishing times on transposed graph
        int scc = 0;
        while (!st.isEmpty()) {
            int node = st.pop();
            if (vis[node] == 0) {
                scc++;
                dfs3(node, vis, adjT);
            }
        }

        return scc;
    }
}
