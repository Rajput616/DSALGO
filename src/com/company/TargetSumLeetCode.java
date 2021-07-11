package com.company;

import java.util.Scanner;

public class TargetSumLeetCode {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        int countTargetSum = findTargetSumWays(arr,tar);
        System.out.println(countTargetSum);
    }
    public static int findTargetSumWays(int[] arr, int target) {
        if(arr.length == 0){
            return 0;
        }
        int sum = 0;
        for(int i : arr){
            sum += i;
        }
        int s1 = (target + sum)/2;
        if(sum < target || (target + sum)%2 != 0)
            return 0;
        return countSubsetSum(arr, s1);
    }
    public static int countSubsetSum(int[] arr, int sum){

        int[][] dp = new int[arr.length+1][sum+1];
        for(int i = 0; i < arr.length + 1; i++){
            dp[i][0] = 1;
        }
        for(int i = 1; i < sum + 1; i++){
            dp[0][i] = 0;
        }
        for(int i = 1; i < arr.length+1; i++){
            for(int j = 1; j < sum+1; j++){
                if(arr[i-1] > j || arr[i-1] == 0){
                    dp[i][j] = dp[i-1][j];
                } else{
                    dp[i][j] = dp[i-1][j - arr[i-1]] + dp[i-1][j];
                }
            }
        }
        int countZeroes = 0;
        for(int i : arr){
            if(i == 0)
                countZeroes++;
        }
        if(countZeroes == 0){
            return dp[arr.length][sum];
        } else{
            return (int) Math.pow(2, countZeroes) * dp[arr.length][sum];
        }

    }
}
