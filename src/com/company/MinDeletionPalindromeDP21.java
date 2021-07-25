package com.company;

import java.util.Scanner;

public class MinDeletionPalindromeDP21 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        int LPS = LongestPalindromicSubsequenceDP21.longestPalindromicSubsequence(s);
        System.out.println("Minimum No. of deletions : " + (s.length() - LPS));
    }
}
