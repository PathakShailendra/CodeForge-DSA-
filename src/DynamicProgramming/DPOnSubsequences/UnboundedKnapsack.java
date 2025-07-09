package DynamicProgramming.DPOnSubsequences;

public class UnboundedKnapsack {
    static int knapSack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        Integer[][] dp = new Integer[n][capacity + 1];
        return solve(n - 1, capacity, val, wt, dp);
    }

    static int solve(int i, int W, int[] val, int[] wt, Integer[][] dp) {
        if (i == 0) {
            // We can pick item 0 multiple times as long as W allows
            return (W / wt[0]) * val[0];
        }

        if (dp[i][W] != null) return dp[i][W];

        int notTake = solve(i - 1, W, val, wt, dp);
        int take = 0;
        if (wt[i] <= W) {
            take = val[i] + solve(i, W - wt[i], val, wt, dp);  // stay on same item (unbounded)
        }

        return dp[i][W] = Math.max(take, notTake);
    }
}
