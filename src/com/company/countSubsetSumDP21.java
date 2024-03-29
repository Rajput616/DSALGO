package com.company;

import java.util.Scanner;

public class countSubsetSumDP21 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int sum = scn.nextInt();
        int count = countSubsetSumDP(arr, sum);
        System.out.println(count);
    }
    public static int countSubsetSumDP(int[] arr, int sum){
        int[][] dp = new int[arr.length+1][sum+1];
        for(int i = 0; i < arr.length+1; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < sum+1; i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i < arr.length+1; i++){
            for(int j = 1; j < sum+1; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] + dp[i-1][j];
                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }

}
