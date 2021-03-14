package com.company;

import java.util.Scanner;

public class CountSubsetSumDP {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int tar = scn.nextInt();
        int[][] t = new int[n+1][tar+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < tar+1; j++){
                if(i == 0){
                    t[i][j] = 0;
                }
                if(j == 0){
                    t[i][j] = 1;
                }
            }
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < tar+1; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j - arr[i-1]] + t[i-1][j];
                }
                else
                    t[i][j] = t[i-1][j];
            }
        }
        System.out.println(t[n][tar]);
    }
}
