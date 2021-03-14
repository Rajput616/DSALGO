package com.company;

import java.util.Scanner;

public class MCMMemoizationDP {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int ans = MCMMemoized(arr , 1, n-1);
        System.out.println(ans);
    }
    static int[][] t = new int[1001][1001];
    public static int MCMMemoized(int[] arr, int i, int j){
        if(i >= j){
            return 0;
        }
        if(t[i][j] != 0){
            return t[i][j];
        }
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j-1; k++){
            int temp = MCMMemoized(arr, i, k) + MCMMemoized(arr, k+1, j) + arr[i-1] * arr[k] * arr[j];
            if(min > temp){
                min = temp;
            }
        }
        return t[i][j] = min;
    }
}
