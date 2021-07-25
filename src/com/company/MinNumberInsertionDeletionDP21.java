package com.company;

import java.util.Scanner;

public class MinNumberInsertionDeletionDP21 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        minInsertionDeletion(s1, s2);
    }
    public static void minInsertionDeletion(String s1, String s2){
        if(s1.length() == 0){
            System.out.println("Minimum No. of Insertions : " + s2.length());
            System.out.println("Minimum No. of Deletions : " + 0);
        }
        if(s2.length() == 0){
            System.out.println("Minimum No. of Insertions : " + 0);
            System.out.println("Minimum No. of Deletions : " + s1.length());
        }
        int LCS = LCS(s1, s2, new int[s1.length()+1][s2.length()+1]);
        System.out.println("Minimum No. of Insertions : " + (s2.length()-LCS));
        System.out.println("Minimum No. of Deletions : " + (s1.length()-LCS));
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
