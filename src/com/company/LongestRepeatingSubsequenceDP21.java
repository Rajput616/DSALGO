package com.company;

import java.util.Scanner;

public class LongestRepeatingSubsequenceDP21 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        int LRS = longestRepeatingSubsequence(s);
        System.out.println(LRS);
    }
    public static int longestRepeatingSubsequence(String s) {
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int i = 0; i < s.length()+1; i++){
            dp[i][0] = 0;
        }
        for(int i = 1; i < s.length()+1; i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i < s.length()+1; i++){
            for(int j = 1; j < s.length()+1; j++){
                if(s.charAt(i-1) == s.charAt(j-1) && i != j){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[s.length()][s.length()];
    }
}
