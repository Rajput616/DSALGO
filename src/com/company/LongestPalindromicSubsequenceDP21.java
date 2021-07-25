package com.company;

import java.util.Scanner;

public class LongestPalindromicSubsequenceDP21 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        int LPS = longestPalindromicSubsequence(s);
        System.out.println(LPS);
    }
    public static int longestPalindromicSubsequence(String s){
        StringBuilder st = new StringBuilder(s);
        return LCS(s, st.reverse().toString(), new int[s.length()+1][st.length()+1]);
    }
    public static int LCS(String s1, String s2, int[][] dp){
        for(int i = 0; i < s1.length()+1; i++){
            dp[i][0] = 0;
        }
        for(int i = 1; i < s2.length()+1; i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i < s1.length()+1; i++){
            for(int j = 1; j < s2.length()+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
