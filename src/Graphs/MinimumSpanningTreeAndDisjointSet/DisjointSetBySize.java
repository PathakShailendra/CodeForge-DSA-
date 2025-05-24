package Graphs.MinimumSpanningTreeAndDisjointSet;

import java.util.ArrayList;
import java.util.List;

public class DisjointSetBySize {

    static class DSU {
        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        public DSU(int n) {
            for (int i = 0; i <= n; i++) {
                parent.add(i);      // Initially, har node ka parent woh khud hai
                size.add(1);        // Har set ka size initially 1 hota hai
            }
        }

        // Find with Path Compression
        public int find(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            int root = find(parent.get(node));
            parent.set(node, root); // Path Compression
            return root;
        }

        // Union by Size
        public void union(int u, int v) {
            int parentU = find(u);
            int parentV = find(v);

            if (parentU == parentV) return; // Already in same set

            // Smaller size gets attached to larger size
            if (size.get(parentU) < size.get(parentV)) {
                parent.set(parentU, parentV);
                size.set(parentV, size.get(parentV) + size.get(parentU));
            } else {
                parent.set(parentV, parentU);
                size.set(parentU, size.get(parentU) + size.get(parentV));
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

            if (dsu.find(3) == dsu.find(7)) {
                System.out.println("Same");
            } else {
                System.out.println("Not Same");
            }

            dsu.union(3, 7);

            if (dsu.find(3) == dsu.find(7)) {
                System.out.println("Same");
            } else {
                System.out.println("Not Same");
            }
        }
}
