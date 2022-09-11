class Solution {
    public int maxProfit(int[] prices) {
        int buyDay = 0, profit = 0;
        for(int i = 0; i < prices.length; ++i){
            if(prices[buyDay] > prices[i]) buyDay = i;
            profit = Math.max(profit, prices[i] - prices[buyDay]);
        }
        return profit;
    }
}