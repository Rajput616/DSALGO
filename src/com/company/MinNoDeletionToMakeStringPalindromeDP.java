package com.company;

import java.util.Scanner;

public class MinNoDeletionToMakeStringPalindromeDP {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String a = scn.next();
        int ans = a.length() - LPS(a);
        System.out.println(ans);
    }
    public static int LPS(String a) {
        StringBuilder b = new StringBuilder();
        for(int i = a.length() - 1; i >= 0; i--)
            b.append(a.charAt(i));
        return LCS(a, b.toString());
    }
    public static int LCS(String a, String b) {
        int n = a.length();
        int m = b.length();
        int[][] t = new int[n+1][m+1];
        for(int i = 0 ; i < n+1; i++){
            for(int j = 0; j < m+1; j++){
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }
            }
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < m+1; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }
                else{
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
                }
            }
        }
        return t[n][m];
    }
}
