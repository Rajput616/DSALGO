package com.company;

import java.util.Scanner;

public class MinPathMazeUsingDP {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] mat = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                mat[i][j] = scn.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                if(i == n-1){
                    dp[i][j] = (j==m-1)?mat[i][j]:(mat[i][j] + dp[i][j+1]);
                } else if(j == m-1){
                    dp[i][j] = mat[i][j] + dp[i+1][j];
                }
            }
        }
        for(int i = n-2; i >= 0; i--){
            for(int j = m-2; j >= 0; j--){
                dp[i][j] = mat[i][j] + Math.min(dp[i+1][j] , dp[i][j+1]);
            }
        }
        System.out.println(dp[0][0]);
    }
}
