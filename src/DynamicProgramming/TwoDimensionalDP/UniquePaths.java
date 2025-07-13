package DynamicProgramming.TwoDimensionalDP;

import java.util.Arrays;

public class UniquePaths {
    public int solve(int i, int j, int m, int n, int[][] dp){
        if(i == m-1 && j == n-1){
            return 1;
        }
        if(i >= m || j >= n){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];

        int way1 = solve(i, j+1, m, n, dp);
        int way2 = solve(i+1, j, m ,n, dp);
        return dp[i][j] = way1+way2;
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(0,0,m,n, dp);
    }
}
