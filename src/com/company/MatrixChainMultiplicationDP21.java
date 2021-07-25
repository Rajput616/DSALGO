package com.company;

import java.util.Scanner;

public class MatrixChainMultiplicationDP21 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int[][] dp = new int[n+1][n+1];
        int minCost = mcmRecursive(arr, 1, n-1, dp);
        System.out.println(minCost);
    }

    public static int mcmRecursive(int[] arr, int i, int j, int[][] dp){
        if(i >= j){
            return 0;
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int tempAns = mcmRecursive(arr, i, k, dp) + mcmRecursive(arr, k + 1, j, dp) + (arr[i-1] * arr[k] * arr[j]);
            min = Math.min(min, tempAns);
        }
        dp[i][j] = min;
        return dp[i][j];
    }

}
