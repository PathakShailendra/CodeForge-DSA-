package DynamicProgramming.DpOnStocks;

public class BestTimeToBuyAndSellStockIITab {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        dp[n][0] = dp[n][1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            dp[i][1] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);

            dp[i][0] = Math.max(prices[i] + dp[i + 1][1], dp[i + 1][0]);
        }

        return dp[0][1];
    }
}
