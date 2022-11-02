// class Solution {
//     public int longestCommonSubsequence(String s, String t) {
//         int len1 = s.length();
//         int len2 = t.length();
//         int[][] dp = new int[len1+1][len2+1];
//         for(int i = 1; i <= len1; ++i){
//             for(int j = 1; j <= len2; ++j){
//                 if(s.charAt(i-1) == t.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
//                 else  dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
//             }
//         }
//         return dp[len1][len2];
//     }
// }
 //Memoized
    class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        return lcs(len1-1, len2-1, s, t, new int[len1][len2]);
    }
    private int lcs(int i, int j, String s, String t, int[][] dp){
        if(i < 0 || j < 0) return 0;
        if(dp[i][j] != 0) return dp[i][j];
        
        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = 1 + lcs(i-1, j-1, s, t, dp);
        } else{
            return dp[i][j] = Math.max(lcs(i-1, j, s, t, dp), lcs(i, j-1, s, t, dp));
        }
    }
}

//Recursive
/*
    class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        return lcs(len1-1, len2-1, s, t);
    }
    private int lcs(int i, int j, String s, String t){
        if(i < 0 || j < 0) return 0;
        
        if(s.charAt(i) == t.charAt(j)) {
            return 1 + lcs(i-1, j-1, s, t);
        } else{
            return Math.max(lcs(i-1, j, s, t), lcs(i, j-1, s, t));
        }
    }
}
*/

