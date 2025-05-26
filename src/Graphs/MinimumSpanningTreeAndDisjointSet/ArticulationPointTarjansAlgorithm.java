package Graphs.MinimumSpanningTreeAndDisjointSet;

import java.util.ArrayList;

public class ArticulationPointTarjansAlgorithm {
    private int timer = 1;

    private void dfs(int node, int parent, int[] vis, int[] tin, int[] low,
                     ArrayList<ArrayList<Integer>> adj, boolean[] isAP) {

        vis[node] = 1;
        tin[node] = low[node] = timer++;
        int childCount = 0;

        for (Integer it : adj.get(node)) {
            if (it == parent) continue;

            if (vis[it] == 0) {
                dfs(it, node, vis, tin, low, adj, isAP);
                low[node] = Math.min(low[node], low[it]);

                // Articulation Point condition for non-root nodes
                if (low[it] >= tin[node] && parent != -1) {
                    isAP[node] = true;
                }

                childCount++;
            } else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }

        // Articulation Point condition for root node
        if (parent == -1 && childCount > 1) {
            isAP[node] = true;
        }
    }

    public ArrayList<Integer> articulationPoints(int V,
                                                 ArrayList<ArrayList<Integer>> adj) {
        // Code here

        int[] vis = new int[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        boolean[] isAP = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, -1, vis, tin, low, adj, isAP);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (isAP[i]) {
                ans.add(i);
            }
        }

        if (ans.isEmpty()) {
            ans.add(-1);
        }

        return ans;

    }
}
