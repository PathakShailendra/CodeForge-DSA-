package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberofDistinctIslands {
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Set<String> shapes = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<String> shape = new ArrayList<>();
                    dfs(grid, visited, i, j, i, j, shape);
                    shapes.add(String.join(",", shape));
                }
            }
        }
        return shapes.size();
    }


    private void dfs(int[][] grid, boolean[][] visited, int i, int j, int baseRow, int baseCol, List<String> shape) {
        int n = grid.length, m = grid[0].length;

        if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || grid[i][j] == 0)
            return;

        visited[i][j] = true;

        // Store relative position
        shape.add((i - baseRow) + "_" + (j - baseCol));

        // Explore all 4 directions
        dfs(grid, visited, i + 1, j, baseRow, baseCol, shape); // down
        dfs(grid, visited, i - 1, j, baseRow, baseCol, shape); // up
        dfs(grid, visited, i, j + 1, baseRow, baseCol, shape); // right
        dfs(grid, visited, i, j - 1, baseRow, baseCol, shape); // left
    }
}
