package DynamicProgramming.DpOnStocks;

public class BestTimeToBuyAndSellStockWithCooldownTab {

        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][] dp = new int[n + 2][2]; // we use n+2 to handle i+2 case safely

            // Base case is already 0 by default in Java

            for (int i = n - 1; i >= 0; i--) {
                for (int canBuy = 0; canBuy <= 1; canBuy++) {
                    int profit = 0;

                    if (canBuy == 1) {
                        int buy = -prices[i] + dp[i + 1][0];
                        int skip = dp[i + 1][1];
                        profit = Math.max(buy, skip);
                    } else {
                        int sell = prices[i] + dp[i + 2][1];
                        int skip = dp[i + 1][0];
                        profit = Math.max(sell, skip);
                    }

                    dp[i][canBuy] = profit;
                }
            }

            return dp[0][1]; // start from day 0, can buy
        }
    }
