package com.company;

import java.util.Scanner;

public class LCSRecursiveDP21 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int lcs = LCSTopDown(s1, s2, dp);
        System.out.println(lcs);
        for (int[] ints : dp) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    public static int LCSTopDown(String s1, String s2, int[][] dp){
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

    public static int LCSRecursive(String s1, String s2, int[][] dp){
        if(s1.length() == 0 || s2.length() == 0){
            return 0;
        }
        if(dp[s1.length()][s2.length()] != 0){
            return dp[s1.length()][s2.length()];
        }
        if(s1.charAt(s1.length()-1) == s2.charAt(s2.length()-1)){
            dp[s1.length()][s2.length()] =  1 + LCSRecursive(s1.substring(0,s1.length()-1), s2.substring(0, s2.length()-1), dp);
        } else{
            dp[s1.length()][s2.length()] = Math.max(LCSRecursive(s1.substring(0,s1.length()-1), s2, dp), LCSRecursive(s1, s2.substring(0, s2.length()-1), dp));
        }
        return dp[s1.length()][s2.length()];
    }


}
