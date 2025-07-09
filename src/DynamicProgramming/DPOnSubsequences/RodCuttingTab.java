package DynamicProgramming.DPOnSubsequences;

public class RodCuttingTab {
    public int cutRod(int[] price) {
        int n = price.length;
        int[][] dp = new int[n][n + 1];

        // Base case: using only rod of length 1 (index 0)
        for (int len = 0; len <= n; len++) {
            dp[0][len] = len * price[0];
        }

        for (int i = 1; i < n; i++) {
            int rodLen = i + 1;
            for (int len = 0; len <= n; len++) {
                int notPick = dp[i - 1][len];
                int pick = 0;
                if (rodLen <= len) {
                    pick = price[i] + dp[i][len - rodLen];
                }
                dp[i][len] = Math.max(pick, notPick);
            }
        }

        return dp[n - 1][n];
    }
}
