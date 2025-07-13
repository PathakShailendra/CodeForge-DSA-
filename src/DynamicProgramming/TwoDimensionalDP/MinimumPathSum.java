package DynamicProgramming.TwoDimensionalDP;

import java.util.Arrays;

public class MinimumPathSum {
    private int solve(int i, int j, int m, int n, int[][] grid, int [][]dp) {
        if (i >= m || j >= n) return Integer.MAX_VALUE;

        if (i == m - 1 && j == n - 1) return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j];

        int right = solve(i, j + 1, m, n, grid, dp);
        int down = solve(i + 1, j, m, n, grid, dp);

        return dp[i][j] = grid[i][j] + Math.min(right, down);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][]dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0, 0, m, n, grid, dp);
    }
}
