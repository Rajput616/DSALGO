class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2*k+2];
        for(int i = n-1; i >= 0; --i){
            for(int numTrans = 2*k; numTrans >= 0; --numTrans){
                int profit = dp[i+1][numTrans];
                if(numTrans%2 == 0){
                    profit = Math.max(profit, -prices[i] + dp[i+1][numTrans+1]);
                } else{
                    profit = Math.max(profit, prices[i] + dp[i+1][numTrans+1]);
                }


                dp[i][numTrans] = profit;
            }
        }
        return dp[0][0];
    }
}
