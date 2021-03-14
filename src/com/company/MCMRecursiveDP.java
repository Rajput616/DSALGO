package com.company;

import java.util.Scanner;

public class MCMRecursiveDP {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int ans = MCM(arr, 1, n-1);
        System.out.println(ans);
    }
    public static int MCM(int[] arr, int i, int j){
        if(i >= j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int k = i; k <= j-1 ; k++){
            int temp = MCM(arr, i, k) + MCM(arr, k+1, j) + arr[i-1] * arr[k] * arr[j];
            if(temp < min){
                min = temp;
            }
        }
        return min;
    }
}

