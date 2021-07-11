package com.company;

import java.util.Scanner;

public class ZeroOneKnapsackMemoizationDP {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];
        for(int i = 0; i < n; i++){
            wt[i] = scn.nextInt();
        }
        for(int i = 0; i < n; i++){
            val[i] = scn.nextInt();
        }
        int W = scn.nextInt();
        int[][] dp = new int[n+1][W+1];
        int profit = knapsackRecursive( wt, val, W, n, dp);
        System.out.println(profit);
    }

    public static int knapsackRecursive(int[] wt, int[] val, int W, int n, int[][] dp){
        if(n == 0 || W == 0){
            return 0;
        }
        if(dp[n][W] > 0){
            return dp[n][W];
        }
        if(wt[n-1] <= W){
            dp[n][W] = Math.max(val[n-1] + knapsackRecursive(wt, val, W-wt[n-1], n-1, dp), knapsackRecursive(wt, val, W, n-1, dp));
        } else{
            dp[n][W] = knapsackRecursive(wt, val, W, n-1, dp);
        }
        return dp[n][W];
    }
}
