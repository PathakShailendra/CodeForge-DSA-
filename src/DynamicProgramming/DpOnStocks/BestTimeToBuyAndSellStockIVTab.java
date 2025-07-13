package DynamicProgramming.DpOnStocks;

public class BestTimeToBuyAndSellStockIVTab {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) return 0;

        if (k >= n / 2) {
            int profit = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        int[][][] dp = new int[n + 1][2][k + 1];


        for (int i = n - 1; i >= 0; i--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (canBuy == 1) {
                        int buy = -prices[i] + dp[i + 1][0][cap];
                        int skip = dp[i + 1][1][cap];
                        dp[i][1][cap] = Math.max(buy, skip);
                    } else {
                        int sell = prices[i] + dp[i + 1][1][cap - 1];
                        int skip = dp[i + 1][0][cap];
                        dp[i][0][cap] = Math.max(sell, skip);
                    }
                }
            }
        }

        return dp[0][1][k];
    }
}
