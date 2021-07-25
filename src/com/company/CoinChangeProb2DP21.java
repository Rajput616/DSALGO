package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChangeProb2DP21 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] coins = new int[n];
        for(int i = 0; i < n; i++){
            coins[i] = scn.nextInt();
        }
        Arrays.sort(coins);
        int coinSum = scn.nextInt();
        int[][] dp = new int[n+1][coinSum+1];
        for(int i = 0; i < coinSum+1; i++){
            dp[0][i] = Integer.MAX_VALUE-1;
        }
        for(int i = 1; i < n+1; i++){
            dp[i][0] = 0;
        }
        for(int i = 1; i < coinSum+1; i++){
            if(i % coins[0] == 0){
                dp[1][i] = i / coins[0];
            } else{
                dp[1][i] = Integer.MAX_VALUE-1;
            }
        }
        for(int i = 2; i < n+1; i++){
            for(int j = 1; j < coinSum+1; j++){
                if(coins[i-1] <= j){
                    dp[i][j] = Math.min(dp[i][j - coins[i-1]] + 1, dp[i-1][j]);
                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][coinSum]);
    }
}
