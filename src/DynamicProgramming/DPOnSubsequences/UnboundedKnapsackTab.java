package DynamicProgramming.DPOnSubsequences;

public class UnboundedKnapsackTab {
    static int knapSack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        int[][] dp = new int[n][capacity + 1];

        // Base case: only item 0
        for (int w = 0; w <= capacity; w++) {
            dp[0][w] = (w / wt[0]) * val[0]; // maximum times we can pick item 0
        }

        // Fill DP table
        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= capacity; w++) {

                int notTake = dp[i - 1][w]; // skip the item
                int take = 0;
                if (wt[i] <= w) {
                    take = val[i] + dp[i][w - wt[i]]; // pick it and stay on i (unbounded)
                }

                dp[i][w] = Math.max(take, notTake);
            }
        }

        return dp[n - 1][capacity];
    }
}
