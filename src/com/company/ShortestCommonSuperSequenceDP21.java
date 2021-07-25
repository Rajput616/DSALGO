package com.company;

import java.util.Scanner;

public class ShortestCommonSuperSequenceDP21 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        int length = shortestCommonSuperSequence(s1, s2);
        System.out.println(length);
    }
    public static int shortestCommonSuperSequence(String s1, String s2){
        int LCS = LCS(s1, s2, new int[s1.length()+1][s2.length()+1]);
        return s1.length() + s2.length() - LCS;
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
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
