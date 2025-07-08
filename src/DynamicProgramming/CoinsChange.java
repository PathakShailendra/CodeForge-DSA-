package DynamicProgramming;

import java.util.Arrays;

public class CoinsChange {
    private int solve(int i, int target, int[] coins, int[][] dp) {
        if (i == 0) {
            if (target % coins[i] == 0) return target / coins[i];
            else return (int)1e9;
        }

        if (dp[i][target] != -1) return dp[i][target];

        int notTake = solve(i - 1, target, coins, dp);
        int take = (int)1e9;
        if (coins[i] <= target) {
            take = 1 + solve(i, target - coins[i], coins, dp);
        }

        return dp[i][target] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int target) {
        int n = coins.length;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        int ans = solve(n - 1, target, coins, dp);
        return ans >= (int)1e9 ? -1 : ans;
    }
}
