package Graphs;

public class MatrixConnectedComponents {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 1},
                {0, 0, 0, 1}
        };

        System.out.println("Number of connected components: " + countComponents(grid));
    }

    // Count connected components in the grid
    public static int countComponents(int[][] grid) {
        int rows = grid.length;        // Total rows
        int cols = grid[0].length;     // Total columns
        boolean[][] visited = new boolean[rows][cols];  // To track visited cells

        int count = 0;  // Component counter

        // Step 1: Traverse each cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Step 2: If it's a 1 and not visited
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, grid, visited);  // DFS call
                    count++;  // Found one new component
                }
            }
        }

        return count;
    }

    // DFS Function to mark all connected 1s from (i, j)
    private static void dfs(int i, int j, int[][] grid, boolean[][] visited) {
        // Movement directions: Up, Down, Left, Right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        visited[i][j] = true;  // Mark current cell as visited

        // Check all 4 directions
        for (int d = 0; d < 4; d++) {
            int ni = i + dx[d];  // New row index
            int nj = j + dy[d];  // New col index

            // Check bounds and unvisited 1
            if (ni >= 0 && nj >= 0 && ni < grid.length && nj < grid[0].length &&
                    grid[ni][nj] == 1 && !visited[ni][nj]) {
                dfs(ni, nj, grid, visited);  // Recursive DFS
            }
        }
    }
}
