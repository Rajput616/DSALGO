class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2*k+1];
        return checkProfit(0, 0, 2*k, prices, dp);
    }
    private int checkProfit(int i, int numTrans, int k, int[] prices, int[][] dp){
        if(i >= prices.length || numTrans == k) return 0;
        
        if(dp[i][numTrans] != 0) return dp[i][numTrans];
        
        int profit = checkProfit(i+1, numTrans, k, prices, dp);
        if(numTrans%2 == 0){
            profit = Math.max(profit, -prices[i] + checkProfit(i+1, numTrans+1, k, prices, dp));
        } else{
            profit = Math.max(profit, prices[i] + checkProfit(i+1, numTrans+1, k, prices, dp));
        }
        
        
        return dp[i][numTrans] = profit;
    }
}
