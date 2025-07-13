package DynamicProgramming.DpOnStocks;

public class BestTimeToBuyAndSellStockIIITab {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n + 1][2][3];

        for (int i = n - 1; i >= 0; i--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                for (int cap = 1; cap <= 2; cap++) {

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

        return dp[0][1][2];
    }
}
