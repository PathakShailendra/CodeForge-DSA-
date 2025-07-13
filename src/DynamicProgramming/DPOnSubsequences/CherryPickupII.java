package DynamicProgramming.DPOnSubsequences;

import java.util.Arrays;

public class CherryPickupII {
    int[][][] dp;
    int rows, cols;

    private int solve(int i, int j1, int j2, int[][] grid) {
        if (j1 < 0 || j1 >= cols || j2 < 0 || j2 >= cols) {
            return 0;
        }

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        }

        int result = 0;

        if (j1 == j2) {
            result = grid[i][j1];
        } else {
            result = grid[i][j1] + grid[i][j2];
        }

        if (i == rows - 1) {
            return result;
        }

        int maxCherries = 0;
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                maxCherries = Math.max(maxCherries, solve(i + 1, j1 + dj1, j2 + dj2, grid));
            }
        }

        result += maxCherries;
        dp[i][j1][j2] = result;
        return result;
    }


    public int cherryPickup(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        dp = new int[rows][cols][cols];
        for (int[][] row : dp) {
            for (int[] col : row) {
                Arrays.fill(col, -1);
            }
        }

        return solve(0, 0, cols - 1, grid);
    }
}
