package DynamicProgramming.DPOnSubsequences;

public class RodCutting {
    public int cutRod(int[] price) {
        int n = price.length;
        Integer[][] dp = new Integer[n][n + 1];
        return helper(n - 1, n, price, dp);
    }

    private int helper(int i, int len, int[] price, Integer[][] dp) {
        if (i == 0) {
            // Only piece of length 1 is available
            return len * price[0];
        }

        if (dp[i][len] != null) return dp[i][len];

        int notPick = helper(i - 1, len, price, dp);
        int pick = 0;
        int rodLen = i + 1;
        if (rodLen <= len) {
            pick = price[i] + helper(i, len - rodLen, price, dp);
        }

        return dp[i][len] = Math.max(pick, notPick);
    }
}
