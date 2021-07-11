package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class minSubsetSumDiffDP21 {
    public static void main(String[] args) {
         Scanner scn = new Scanner(System.in);
         int n = scn.nextInt();
         int[] arr = new int[n];
         for(int i = 0; i < n; i++){
             arr[i] = scn.nextInt();
         }
         int min = minSubsetSumDiff(arr);
        System.out.println(min);
    }

    public static int minSubsetSumDiff(int[] arr){
        if(arr.length == 0){
            return 0;
        }
        int range = 0;
        for(int i : arr){
            range += i;
        }
        boolean[][] dp = new boolean[arr.length+1][range+1];
        subsetSum(arr, dp);
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = arr.length, j = 0; j < (range+1)/2; j++){
            if(dp[i][j]){
                al.add(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int val : al) {
            min = Math.min(min, range - 2*val);
        }
        return min;
    }
    public static void subsetSum(int[] arr, boolean[][] dp){
        for(int i = 0; i < dp.length; i++){
           dp[i][0] = true;
        }
        for(int j = 1; j < dp[0].length; j++){
                dp[0][j] = false;
        }
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                } else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }
}
