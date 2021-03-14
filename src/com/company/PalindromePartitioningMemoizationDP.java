package com.company;

import java.util.Scanner;

public class PalindromePartitioningMemoizationDP {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        int ans = PalinPartitionMemoized(s);
        System.out.println(ans);
    }
    static int[][] t = new int[1001][1001];
    public static int PalinPartitionMemoized(String s){
        int i = 0;
        int j = s.length()- 1;
        if(i >= j){
            return 0;
        }
        if(isPalindrome(s)){
            return 0;
        }
        if(t[i][j] != 0){
            return t[i][j];
        }
        int ans = Integer.MAX_VALUE;
        int left, right;
        for(int k = i; k <= j-1; k++){
            if(t[i][k] != 0){
                left = t[i][k];
            }
            else{
                left = PalinPartitionMemoized(s.substring(i,k+1));
                t[i][k] = left;
            }
            if(t[k+1][j] != 0){
                right = t[k+1][j];
            }
            else{
                right = PalinPartitionMemoized(s.substring(k+1,j+1));
                t[k+1][j] = right;
            }
            int temp = 1+ left + right;
//            int temp = PalinPartitionRecursive(s.substring(i,k+1)) +
//                    PalinPartitionRecursive(s.substring(k+1,j+1) )
//                    + 1;
            ans = Math.min(ans,temp);
        }
        return t[i][j] = ans;
    }
    public static boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
