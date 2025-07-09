package DynamicProgramming.DPOnSubsequences;

public class CoinChangeII {
    private int countWays(int i, int amountLeft, int[] coins, Integer[][] dp) {
        if (amountLeft == 0) return 1;

        if (i == coins.length || amountLeft < 0) return 0;

        if (dp[i][amountLeft] != null) return dp[i][amountLeft];

        int pick = countWays(i, amountLeft - coins[i], coins, dp);
        int skip = countWays(i + 1, amountLeft, coins, dp);

        dp[i][amountLeft] = pick + skip;
        return dp[i][amountLeft];
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        Integer[][] dp = new Integer[n][amount + 1];
        return countWays(0, amount, coins, dp);
    }
}
