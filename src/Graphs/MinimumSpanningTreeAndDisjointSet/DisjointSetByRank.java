package Graphs.MinimumSpanningTreeAndDisjointSet;

import java.util.*;
public class DisjointSetByRank {

    static class DSU {
        List<Integer> parent = new ArrayList<>();
        List<Integer> rank = new ArrayList<>();

        public DSU(int n) {
            for (int i = 0; i <= n; i++) {
                parent.add(i);
                rank.add(0);
            }
        }

        // Find with Path Compression
        public int find(int node) {
            if (node == parent.get(node)) {
                return node;
            }

            int root = find(parent.get(node));
            parent.set(node, root);
            return root;
        }

        // Union by Rank
        public void union(int u, int v) {
            int parentU = find(u);
            int parentV = find(v);

            if (parentU == parentV) return;

            if (rank.get(parentU) < rank.get(parentV)) {
                parent.set(parentU, parentV);
            } else if (rank.get(parentV) < rank.get(parentU)) {
                parent.set(parentV, parentU);
            } else {
                parent.set(parentV, parentU);
                rank.set(parentU, rank.get(parentU) + 1);
            }
        }
    }

    public static void main(String[] args) {
        DSU dsu = new DSU(7);

        dsu.union(1, 2);
        dsu.union(2, 3);
        dsu.union(4, 5);
        dsu.union(6, 7);
        dsu.union(5, 6);

        // Check if 3 and 7 are in the same component
        if (dsu.find(3) == dsu.find(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }

        // Now union 3 and 7, then check again
        dsu.union(3, 7);

        if (dsu.find(3) == dsu.find(7)) {
            System.out.println("Same");
        } else {
            System.out.println("Not Same");
        }
    }
}
