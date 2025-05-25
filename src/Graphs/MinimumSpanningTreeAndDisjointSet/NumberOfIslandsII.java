package Graphs.MinimumSpanningTreeAndDisjointSet;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsII {
    class UnionFind {
        int[] parent;

        UnionFind(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }

    public List<Integer> numOfIslands(int n, int m, int[][] operators) {
        // Your code here
        List<Integer> result = new ArrayList<>();
        UnionFind uf = new UnionFind(n * m);
        boolean[][] visited = new boolean[n][m];
        int count = 0;

        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}}; // 4 directions

        for (int[] op : operators) {
            int row = op[0];
            int col = op[1];

            if (visited[row][col]) {
                result.add(count); // already land
                continue;
            }

            visited[row][col] = true;
            count++; // new island created

            int index = row * m + col;

            // Check 4 neighbors
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && visited[newRow][newCol]) {
                    int neighborIndex = newRow * m + newCol;
                    if (uf.find(index) != uf.find(neighborIndex)) {
                        uf.union(index, neighborIndex);
                        count--; // 2 islands merged
                    }
                }
            }

            result.add(count);
        }

        return result;
    }
}
