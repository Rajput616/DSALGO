package com.company;

import java.util.Scanner;

public class CountSubsetGivenDiffDP {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int diff = scn.nextInt();
        int sum = 0;
        for(int i : arr){
            sum = sum + i;
        }
        int s1 = (diff + sum)/2;
        int ans = countSubsetSum(arr, s1);
        System.out.println(ans);
    }
    public static int countSubsetSum(int[] arr, int s1){
        int n = arr.length;
        int[][] t = new int[n+1][s1+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < s1 + 1; j++){
                if(i == 0){
                    t[i][j] = 0;
                }
                if(j == 0){
                    t[i][j] = 1;
                }
            }
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 0; j < s1 +1; j++){
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j - arr[i -1]] + t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][s1];
    }
}
