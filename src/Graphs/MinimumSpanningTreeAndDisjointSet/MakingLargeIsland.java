package Graphs.MinimumSpanningTreeAndDisjointSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingLargeIsland {
    class UnionFind {
        int[] parent;
        public UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) parent[i] = i;
        }

        public int find(int x) {
            if (x != parent[x])
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            if (rx != ry) {
                parent[rx] = ry;
            }
        }
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        UnionFind uf = new UnionFind(n * n);
        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        int id = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int index = i * n + j;
                    for (int[] dir : dirs) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                            int nIndex = ni * n + nj;
                            uf.union(index, nIndex);
                        }
                    }
                }
            }
        }

        Map<Integer, Integer> areaMap = new HashMap<>();
        for (int i = 0; i < n * n; i++) {
            if (grid[i / n][i % n] == 1) {
                int root = uf.find(i);
                areaMap.put(root, areaMap.getOrDefault(root, 0) + 1);
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighbors = new HashSet<>();
                    for (int[] dir : dirs) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 1) {
                            int root = uf.find(ni * n + nj);
                            neighbors.add(root);
                        }
                    }

                    int newSize = 1;
                    for (int root : neighbors) {
                        newSize += areaMap.get(root);
                    }
                    max = Math.max(max, newSize);
                }
            }
        }

        if (max == 0) {
            return n * n;
        }

        return max;
    }
}
