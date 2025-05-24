package Graphs.MinimumSpanningTreeAndDisjointSet;

public class NumberOfOprToMakeNetworkConnected {
    class DisjointSet {
        int[] parent, size;

        DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int node) {
            if (parent[node] == node) return node;
            return parent[node] = find(parent[node]);
        }

        boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv) return false;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
            return true;
        }
    }


    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        DisjointSet ds = new DisjointSet(n);
        int components = n;

        for (int[] conn : connections) {
            if (ds.union(conn[0], conn[1])) {
                components--;
            }
        }

        return components - 1;
    }
}
