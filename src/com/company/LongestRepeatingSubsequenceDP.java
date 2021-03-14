package com.company;

import java.util.Scanner;

public class LongestRepeatingSubsequenceDP {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text = scn.next();
        int ans = LCS(text);
        System.out.println(ans);
    }
    public static int LCS(String text){
        int n = text.length();
        int[][] t = new int[n+1][n +1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < n +1; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }
            }
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j< n +1; j++){
                if(text.charAt(i-1) == text.charAt(j-1) && i != j){ //Slight change from LCS i.e i!=j
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
                }
            }
        }
        return t[n][n];
    }
}
