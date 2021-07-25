package com.company;

import java.util.Scanner;

public class MinInsertionForPalindrome {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        int minInsertion = minInsertionForPalindrome(s);
        System.out.println(minInsertion);
    }
    public static int minInsertionForPalindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        int LCS = LongestPalindromicSubsequenceDP21.LCS(s, sb.reverse().toString(), new int[s.length()+1][s.length()+1]);
        return s.length() - LCS;
    }

}
