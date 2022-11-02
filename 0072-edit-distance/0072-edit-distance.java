class Solution {
    public int minDistance(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        return minD(len1-1, len2-1, s, t, new int[len1][len2]);
    }
    private int minD(int i, int j, String s, String t, int[][] dp){
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        
        if(dp[i][j] != 0) return dp[i][j];
        
        dp[i][j] = minD(i-1, j-1, s, t, dp);
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j];
        } else{
            return dp[i][j] = 1 + Math.min(minD(i, j-1, s, t, dp), Math.min(minD(i-1, j, s, t, dp), dp[i][j]));
        }
    }
}