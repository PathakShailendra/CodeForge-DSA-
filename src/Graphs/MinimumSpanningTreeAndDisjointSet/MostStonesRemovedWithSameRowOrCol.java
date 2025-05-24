package Graphs.MinimumSpanningTreeAndDisjointSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostStonesRemovedWithSameRowOrCol {
    class DisjointSet {
        Map<Integer, Integer> parent = new HashMap<>();
        Map<Integer, Integer> size = new HashMap<>();

        int find(int x) {
            if (parent.get(x) == x) return x;
            parent.put(x, find(parent.get(x)));
            return parent.get(x);
        }

        void union(int u, int v) {
            int pu = find(u);
            int pv = find(v);
            if (pu == pv) return;

            int su = size.get(pu);
            int sv = size.get(pv);

            if (su < sv) {
                parent.put(pu, pv);
                size.put(pv, su + sv);
            } else {
                parent.put(pv, pu);
                size.put(pu, su + sv);
            }
        }

        void add(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
                size.put(x, 1);
            }
        }

        int countComponents() {
            Set<Integer> uniqueParents = new HashSet<>();
            for (int key : parent.keySet()) {
                uniqueParents.add(find(key));
            }
            return uniqueParents.size();
        }
    }

    public int removeStones(int[][] stones) {
        DisjointSet ds = new DisjointSet();
        int OFFSET = 10001;

        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + OFFSET;

            ds.add(row);
            ds.add(col);

            ds.union(row, col);
        }

        int numComponents = ds.countComponents();
        return stones.length - numComponents;
    }
}
