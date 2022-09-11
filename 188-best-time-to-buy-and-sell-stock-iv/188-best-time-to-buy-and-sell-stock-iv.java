class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][k+1][2];
        return checkProfit(0, 0, k, prices, dp);
    }
    private int checkProfit(int i, int buy, int numTrans, int[] prices, int[][][] dp){
        if(i >= prices.length || numTrans == 0) return 0;
        
        if(dp[i][numTrans][buy] != 0) return dp[i][numTrans][buy];
        
        int profit = checkProfit(i+1, buy, numTrans, prices, dp);
        if(buy == 0){
            profit = Math.max(profit, -prices[i] + checkProfit(i+1, 1, numTrans, prices, dp));
        } else{
            profit = Math.max(profit, prices[i] + checkProfit(i+1, 0, numTrans-1, prices, dp));
        }
        
        
        return dp[i][numTrans][buy] = profit;
    }
}
