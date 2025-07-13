package DynamicProgramming.DPOnSubsequences;

public class CoinChangeTab {
    public int coinChange(int[] coins, int target) {
        int n = coins.length;
        int[][] dp = new int[n][target + 1];

        for(int t = 0; t <= target; t++) {
            if(t % coins[0] == 0) dp[0][t] = t/coins[0];
            else dp[0][t] = (int)1e9;
        }

        for(int i = 1; i < n; i++) {
            for(int t = 0; t <= target; t++) {
                int notTake = dp[i-1][t];
                int take = (int)1e9;
                if(coins[i] <= t) take = 1 + dp[i][t-coins[i]];
                dp[i][t] = Math.min(take, notTake);
            }
        }

        int ans = dp[n-1][target];
        return ans == (int)1e9 ? -1 : ans;
    }
}
