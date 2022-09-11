class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2*k+1];
        for(int i = n-1; i >= 0; --i){
            for(int numTrans = 2*k-1; numTrans >= 0; --numTrans){
                int profit = dp[i+1][numTrans];
                profit = Math.max(profit, dp[i+1][numTrans+1] + ((numTrans%2 == 0) ? -prices[i] : prices[i]));
                dp[i][numTrans] = profit;
            }
        }
        return dp[0][0];
    }
}
