package com.company;

import java.util.Scanner;

public class CheckPalindrome {

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        checkPalindrome(s,0,s.length()-1);
    }
    public static void checkPalindrome(String s,int lo, int hi){
        if(lo<=hi) {
            if(s.charAt(lo) == s.charAt(hi))
                checkPalindrome(s,lo+1,hi-1);
            else {
                System.out.println("False");
                return;
            }
        }
        if(lo>hi) {
            System.out.println("True");
        }
    }
}
