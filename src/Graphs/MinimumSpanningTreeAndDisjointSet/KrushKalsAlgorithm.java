package Graphs.MinimumSpanningTreeAndDisjointSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KrushKalsAlgorithm {

        // Static inner class for Edge
        static class Edge implements Comparable<Edge> {
            int u, v, wt;

            Edge(int u, int v, int wt) {
                this.u = u;
                this.v = v;
                this.wt = wt;
            }

            public int compareTo(Edge other) {
                return this.wt - other.wt;
            }
        }

        // Static inner class for Disjoint Set
        static class DisjointSet {
            int[] parent, size;

            DisjointSet(int n) {
                parent = new int[n];
                size = new int[n];
                for(int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            int find(int node) {
                if(parent[node] == node) return node;
                return parent[node] = find(parent[node]);  // Path Compression
            }

            void union(int u, int v) {
                int pu = find(u);
                int pv = find(v);
                if(pu == pv) return;

                if(size[pu] < size[pv]) {
                    parent[pu] = pv;
                    size[pv] += size[pu];
                } else {
                    parent[pv] = pu;
                    size[pu] += size[pv];
                }
            }
        }

        static int kruskalsMST(int V, int[][] edgeArr) {
            List<Edge> edgeList = new ArrayList<>();

            // Convert 2D array to Edge objects
            for(int[] edge : edgeArr) {
                edgeList.add(new Edge(edge[0], edge[1], edge[2]));
            }

            // Sort all edges based on weight
            Collections.sort(edgeList);

            DisjointSet ds = new DisjointSet(V);
            int mstWeight = 0;

            // Apply Kruskal's Algorithm
            for(Edge e : edgeList) {
                if(ds.find(e.u) != ds.find(e.v)) {
                    mstWeight += e.wt;
                    ds.union(e.u, e.v);
                }
            }

            return mstWeight;
        }

}
