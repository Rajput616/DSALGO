class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return helper(0, 0, m, n, dp);
    }
    private int helper(int i, int j, int m, int n, int[][] dp){
        if(i == m-1 && j == n-1) return 1;
        if(i >= m || j >= n) return 0;
        
        if(dp[i][j] != 0) return dp[i][j];
        
        return dp[i][j] = helper(i+1, j, m, n, dp) + helper(i, j+1, m, n, dp);
    }
}

// class Solution {
//     public int uniquePaths(int m, int n) {
//         int[] prev = new int[n];
//         Arrays.fill(prev, 1);
//         for(int i = 1; i < m; ++i){
//             int[] curr = new int[n];
//             curr[0] = 1;
//             for(int j = 1; j < n; ++j){
//                 curr[j] = prev[j] + curr[j-1];
//             }
//             prev = curr;
//         }
//         return prev[n-1];
//     }
// }