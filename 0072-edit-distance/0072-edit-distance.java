class Solution {
    public int minDistance(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 0; i <= len1; ++i) dp[i][0] = i;
        for(int j = 0; j <= len2; ++j) dp[0][j] = j;
        
        for(int i = 1; i <= len1; ++i){
            for(int j = 1; j <= len2; ++j){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                } else{
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1]));
                }
            }
        }
        return dp[len1][len2];
    }
}

// class Solution {
//     public int minDistance(String s, String t) {
//         int len1 = s.length();
//         int len2 = t.length();
//         return minD(len1-1, len2-1, s, t, new int[len1][len2]);
//     }
//     private int minD(int i, int j, String s, String t, int[][] dp){
//         if(i < 0) return j+1;
//         if(j < 0) return i+1;
        
//         if(dp[i][j] != 0) return dp[i][j];
        
//         dp[i][j] = minD(i-1, j-1, s, t, dp);
//         if(s.charAt(i) == t.charAt(j)){
//             return dp[i][j];
//         } else{
//             return dp[i][j] = 1 + Math.min(minD(i, j-1, s, t, dp), Math.min(minD(i-1, j, s, t, dp), dp[i][j]));
//         }
//     }
// }