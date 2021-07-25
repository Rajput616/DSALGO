package com.company;

import java.util.Scanner;

public class printShortestCommonSubsequenceDP21 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        String ans = printSCS(s1, s2);
        System.out.println(ans);
    }

    public static String printSCS(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        LCS(s1, s2, dp);
        int i = s1.length(), j = s2.length();
        StringBuilder sb = new StringBuilder();
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            } else{
                if(dp[i-1][j] > dp[i][j-1]){
                    sb.append(s1.charAt(i-1));
                    i--;
                } else{
                    sb.append(s2.charAt(j-1));
                    j--;
                }
            }
        }
        while(i > 0){
            sb.append(s1.charAt(i-1));
        }
        while(j > 0){
            sb.append(s2.charAt(j-1));
        }
        return sb.reverse().toString();
    }

    public static void LCS(String s1, String s2, int[][] dp){
        for(int i = 0; i < s1.length()+1; i++){
            dp[i][0]= 0;
        }
        for(int i = 1; i < s2.length()+1; i++){
            dp[0][i]= 0;
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
    }

}
