package DynamicProgramming.DpOnStocks;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {
    private int solve(int i, int canBuy, int cap, int[] prices, int[][][] dp) {
        if (cap == 0 || i == prices.length) return 0;

        if (dp[i][canBuy][cap] != -1) return dp[i][canBuy][cap];

        int profit = 0;

        if (canBuy == 1) {
            int buy = -prices[i] + solve(i + 1, 0, cap, prices, dp);
            int skip = solve(i + 1, 1, cap, prices, dp);
            profit = Math.max(buy, skip);
        } else {
            int sell = prices[i] + solve(i + 1, 1, cap - 1, prices, dp);
            int skip = solve(i + 1, 0, cap, prices, dp);
            profit = Math.max(sell, skip);
        }

        return dp[i][canBuy][cap] = profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n][2][k+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return solve(0, 1, k, prices, dp);
    }
}
