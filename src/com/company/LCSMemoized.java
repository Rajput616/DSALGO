package com.company;
import java.util.Scanner;

public class LCSMemoized {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String text1 = scn.next();
        String text2 = scn.next();
        int sslen = LCS(text1 , text2 , text1.length() , text2.length());
        System.out.println(sslen);
    }
    static int[][] t = new int[1001][1001];
    public static int LCS(String text1, String text2, int n, int m){
        if(n == 0 || m == 0){
            return 0;
        }
        if(t[n][m] != 0){
            return t[n][m];
        }
        if(text1.charAt(n-1) == text2.charAt(m-1)){
            t[n][m] = 1 + LCS(text1, text2, n-1, m-1);
        }
        else{
            t[n][m] = Math.max(LCS(text1,text2,n-1,m) , LCS(text1, text2, n , m-1));
        }
        return t[n][m];
    }
}
