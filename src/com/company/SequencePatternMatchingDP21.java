package com.company;

import java.util.Scanner;

public class SequencePatternMatchingDP21 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        boolean ans = sequencePatternMatching(s1, s2);
        System.out.println(ans);
    }
    public static boolean sequencePatternMatching(String s1, String s2){
        int LCS = LongestPalindromicSubsequenceDP21.LCS(s1, s2, new int[s1.length()+1][s2.length()+1]);
        return Math.min(s1.length(),s2.length()) == LCS;
    }
}
