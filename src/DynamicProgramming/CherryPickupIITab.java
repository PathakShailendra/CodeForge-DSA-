package DynamicProgramming;

import java.util.Arrays;

public class CherryPickupIITab {
    int[][][] dp;
    int rows, cols;

    public int cherryPickup(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        dp = new int[rows][cols][cols];

        for (int[][] layer : dp) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }

        return solve(0, 0, cols - 1, grid);
    }

    private int solve(int i, int j1, int j2, int[][] grid) {
        if (j1 < 0 || j1 >= cols || j2 < 0 || j2 >= cols) return 0;

        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int cherries = 0;
        if (j1 == j2) {
            cherries = grid[i][j1];
        } else {
            cherries = grid[i][j1] + grid[i][j2];
        }

        int max = 0;
        if (i < rows - 1) {
            for (int dj1 = -1; dj1 <= 1; dj1++) {
                for (int dj2 = -1; dj2 <= 1; dj2++) {
                    max = Math.max(max, solve(i + 1, j1 + dj1, j2 + dj2, grid));
                }
            }
        }
        return dp[i][j1][j2] = cherries + max;
    }
}
