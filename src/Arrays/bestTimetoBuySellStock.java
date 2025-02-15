package Arrays;

public class bestTimetoBuySellStock {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices){
            if(price < minPrice){
                minPrice = price;
            }
            else{
                int profit = price - minPrice;
                if(maxProfit < profit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }
}
