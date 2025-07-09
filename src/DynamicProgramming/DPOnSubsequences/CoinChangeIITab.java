package DynamicProgramming.DPOnSubsequences;

public class CoinChangeIITab {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int amt = 1; amt <= amount; amt++) {
            if (amt % coins[0] == 0) {
                dp[0][amt] = 1;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int amt = 1; amt <= amount; amt++) {
                int notPick = dp[i - 1][amt];
                int pick = 0;
                if (amt >= coins[i]) {
                    pick = dp[i][amt - coins[i]];
                }
                dp[i][amt] = pick + notPick;
            }
        }

        return dp[n - 1][amount];
    }
}
