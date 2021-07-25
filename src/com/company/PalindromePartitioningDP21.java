package com.company;

import java.util.Scanner;

public class PalindromePartitioningDP21 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        int[][] dp = new int[s.length()+1][s.length()+1];
        int minPartition = minPalindromePartition(s, 0, s.length()-1, dp);
        System.out.println(minPartition);
    }
    public static int minPalindromePartition(String s, int i , int j,int[][] dp){
        if(i >= j){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        if(isPalindrome(s, i, j)){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int left, right;
        for(int k = i; k < j; k++){
            if(dp[i][k] != 0){
                left = dp[i][k];
            } else{
                left = minPalindromePartition(s, i, k, dp);
                dp[i][k] = left;
            }
            if(dp[k+1][j] != 0){
                right = dp[k+1][j];
            } else{
                right = minPalindromePartition(s, k+1, j, dp) + 1;
                dp[k+1][j] = right;
            }
            int tempAns = left + right;
            min = Math.min(min, tempAns);
        }
        return dp[i][j] = min;
    }
    public static boolean isPalindrome(String s, int i , int j){
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            } else{
                return false;
            }
        }
        return true;
    }
}
