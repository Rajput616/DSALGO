package com.company;

import java.util.Scanner;

public class printLongestCommonSubsequenceDP21 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        String LCS = printLCS(s1, s2, new int[s1.length()+1][s2.length()+1]);
        System.out.println(LCS);
    }

    public static String printLCS(String s1, String s2, int[][] dp){
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
        int i = s1.length(), j = s2.length();
        StringBuilder s = new StringBuilder();
        while(i > 0 && j > 0){
            if(s1.charAt(i-1) == s2.charAt(j-1)){
                s.append(s1.charAt(i-1));
                i--;
                j--;
            } else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            } else{
                j--;
            }
        }
        return s.reverse().toString();
    }
}
