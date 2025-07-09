package DynamicProgramming.DPOnSubsequences;

public class ZeroOneKnapsack {
    static int knapsack(int W, int val[], int wt[]) {
        int n = val.length;
        Integer[][] dp = new Integer[n][W + 1];

        return solve(n - 1, W, val, wt, dp);
    }

    static int solve(int i, int W, int[] val, int[] wt, Integer[][] dp) {
        // Base Case: only one item left
        if (i == 0) {
            if (wt[0] <= W) return val[0];
            else return 0;
        }

        if (dp[i][W] != null) return dp[i][W];

        // Don't take the item
        int notTake = solve(i - 1, W, val, wt, dp);

        // Take the item (if it fits)
        int take = 0;
        if (wt[i] <= W) {
            take = val[i] + solve(i - 1, W - wt[i], val, wt, dp);
        }

        return dp[i][W] = Math.max(take, notTake);
    }
}
