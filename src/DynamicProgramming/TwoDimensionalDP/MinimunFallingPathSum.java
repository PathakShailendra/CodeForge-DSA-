package DynamicProgramming.TwoDimensionalDP;

public class MinimunFallingPathSum {
    public int minFallingPathSum(int[][] mat) {
        int n = mat.length;
        int [][]dp = new int[n][n];

        for(int j = 0; j < n; j++) {
            dp[0][j] = mat[0][j];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int up = dp[i-1][j];
                int left = (j > 0) ? dp[i-1][j-1] : (int) 1e9;
                int right = (j < n-1) ? dp[i-1][j+1] : (int) 1e9;

                dp[i][j] = mat[i][j] + Math.min(up, Math.min(left, right));
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[n-1][i]);
        }
        return ans;
    }
}
