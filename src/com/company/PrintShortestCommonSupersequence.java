package com.company;

import java.util.Scanner;

public class PrintShortestCommonSupersequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text1 = scn.next();
//        String text1 = scn.next();
//        String text2 = "";
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
                    t[i][j] = Math.max(t[i-1][j] , t[i][j-1]);
                }
            }
        }
        StringBuilder s = new StringBuilder();
        int i = n , j = m;
        while( i > 0 && j > 0){
            if( text1.charAt(i-1) == text2.charAt(j-1)){
                s.append(text1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(t[i][j-1] > t[i-1][j]){
                    s.append(text2.charAt(j-1));
                    j--;
                }
                else{
                    s.append(text1.charAt(i-1));
                    i--;
                }
            }
        }
        while(i > 0){
            s.append(text1.charAt(i-1));
            i--;
        }
        while(j > 0){
            s.append(text2.charAt(j-1));
            j--;
        }
        s.reverse();
        System.out.println(s);

    }
}
