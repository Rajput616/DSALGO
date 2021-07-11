package com.company;

import java.util.Scanner;

public class unboundedKnapsackDP21 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] val = new int[n];
        int[] wt = new int[n];
        for(int i = 0; i < val.length; i++){
            val[i] = scn.nextInt();
        }
        for(int j = 0; j < wt.length; j++){
            wt[j] = scn.nextInt();
        }
        int W = scn.nextInt();
        int[][] dp = new int[n+1][W+1];
        for(int i = 0; i < n+1; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i < W+1; i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < W+1; j++){
                if(wt[i-1] <= j){
                    dp[i][j] = Math.max(val[i-1] + dp[i][j - wt[i-1]] , dp[i-1][j]);
                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][W]);
    }
}
