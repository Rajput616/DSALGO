package com.company;

import java.util.Scanner;

public class CoinChangeProb1DP21 {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = scn.nextInt();
        }
        int coinSum = scn.nextInt();
        int[][] dp = new int[n+1][coinSum+1];
        for(int i = 0; i < n+1; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < coinSum+1; i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < coinSum+1; j++){
                if(coins[i-1] <= j){
                    dp[i][j] = dp[i][j - coins[i-1]] + dp[i-1][j];
                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][coinSum]);
    }
}
