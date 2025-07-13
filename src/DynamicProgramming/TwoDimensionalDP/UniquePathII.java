package DynamicProgramming.TwoDimensionalDP;

import java.util.Arrays;

public class UniquePathII {
    public int solve(int i, int j, int m, int n, int[][] dp, int[][] grid) {
        if(i >= m || j >= n || grid[i][j] == 1) return 0;
        if(i == m - 1 && j == n - 1) return 1;

        if(dp[i][j] != -1) return dp[i][j];

        int right = solve(i, j + 1, m, n, dp, grid);
        int down = solve(i + 1, j, m, n, dp, grid);

        return dp[i][j] = right + down;
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(0, 0, m, n, dp, obstacleGrid);
    }
}
