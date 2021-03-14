package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class MinSumSubsetDiffDP {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int range = 0;
        for(int i : arr){
            range = range + i;
        }
        boolean[][] t = TarSumSubset(arr , range);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < (range+1)/2; i++){
           if(t[n][i]){
               ans.add(i);
           }
        }
        int min = Integer.MAX_VALUE;
        for(int i : ans){
            min = Math.min(min, range - 2*i);
        }
        System.out.println(min);

    }
    public static boolean[][] TarSumSubset(int[] arr, int tar){
        int n = arr.length;
        boolean[][] t = new boolean[n + 1][tar + 1];
        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j < tar + 1; j++){
                if(i == 0){
                    t[i][j] = false;
                }
                if(j == 0){
                    t[i][j] = true;
                }
            }
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < tar+1; j++){
                if(arr[i -1] <= j){
                    t[i][j] = t[i-1][j - arr[i - 1]] || t[i - 1][j];
                }
                else{
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t;
    }
}
