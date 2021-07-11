package com.company;

import java.util.Scanner;

public class ZeroOneKnapsackRecursion {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] wt = new int[n];
        int[] val = new int[n];
        for(int i = 0; i < n; i++){
            wt[i] = scn.nextInt();
        }
        for(int i = 0; i < n; i++){
            val[i] = scn.nextInt();
        }
        int W = scn.nextInt();
        int profit = knapsackRecursive( wt, val, W, n);
        System.out.println(profit);
    }
    public static int knapsackRecursive(int[] wt, int[] val, int W, int n){
        if(n == 0 || W == 0){
            return 0;
        }
        if(wt[n-1] <= W){
            return Math.max(val[n-1] + knapsackRecursive(wt, val, W-wt[n-1], n-1), knapsackRecursive(wt, val, W, n-1));
        } else{
            return knapsackRecursive(wt, val, W, n-1);
        }
    }
}
