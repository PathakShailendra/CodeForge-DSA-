package DynamicProgramming.DPOnSubsequences;

public class ZeroOneKnapsackTab {
        static int knapsack(int W, int val[], int wt[]) {
            int n = val.length;

            int[][] dp = new int[n + 1][W + 1];

            // dp[i][w] = max value using first i items with capacity w

            for (int i = 1; i <= n; i++) {
                for (int w = 0; w <= W; w++) {
                    if (wt[i - 1] <= w) {
                        // 2 choices: include or exclude
                        dp[i][w] = Math.max(dp[i - 1][w], val[i - 1] + dp[i - 1][w - wt[i - 1]]);
                    } else {
                        // Can't include current item
                        dp[i][w] = dp[i - 1][w];
                    }
                }
            }

            return dp[n][W]; // Max value with all items and full capacity
        }
}
