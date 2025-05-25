package Graphs.MinimumSpanningTreeAndDisjointSet;

import java.util.Arrays;
import java.util.Comparator;

public class SwimInRisingWater {
    class DSU {
        int[] parent;

        DSU(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) parent[i] = i;
        }

        int find(int x) {
            if (x != parent[x])
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) parent[px] = py;
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] cells = new int[n * n][3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells[i * n + j] = new int[]{grid[i][j], i, j};
            }
        }

        Arrays.sort(cells, Comparator.comparingInt(a -> a[0]));

        DSU dsu = new DSU(n * n);
        boolean[][] visited = new boolean[n][n];

        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};

        for (int[] cell : cells) {
            int time = cell[0];
            int i = cell[1];
            int j = cell[2];
            visited[i][j] = true;
            int curr = i * n + j;

            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni >= 0 && ni < n && nj >= 0 && nj < n && visited[ni][nj]) {
                    int next = ni * n + nj;
                    dsu.union(curr, next);
                }
            }

            if (dsu.find(0) == dsu.find(n * n - 1)) {
                return time;
            }
        }

        return -1;
    }
}
