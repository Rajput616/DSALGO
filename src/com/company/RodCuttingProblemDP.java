package com.company;

import java.util.Scanner;
//Unbounded Knapsack asked in a diff way
public class RodCuttingProblemDP {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] price = new int[n];
        for(int i = 0; i < price.length; i++){
            price[i] = scn.nextInt();
        }
        int len = scn.nextInt();
        int[] larr = new int[len];
        for(int i = 0; i < larr.length; i++){
            larr[i] = i+1;
        }
        int[][] t = new int[n+1][len+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < len+1; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }
            }
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < len+1; j++){
                if(larr[i-1] <= j){
                    t[i][j] = Math.max(price[i-1] + t[i][j - larr[i-1]],t[i-1][j]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        System.out.println(t[n][len]);

    }
}
