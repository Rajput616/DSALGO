package com.company;

import java.util.Scanner;

public class LCSubstringDP {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text1 = scn.next();
        String text2 = scn.next();
        int n = text1.length();
        int m = text2.length();
        int[][] t = new int[n+1][m+1];
        for(int i = 0; i < n+1; i++){
            for(int j = 0; j < m+1; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }
            }
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j< m+1; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else{
                    t[i][j] = 0;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(max < t[i][j])
                    max = t[i][j];
            }
        }
        System.out.println(max);
    }
}
