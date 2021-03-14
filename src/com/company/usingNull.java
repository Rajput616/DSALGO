package com.company;

import java.util.Scanner;

public class usingNull {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s= scn.next();
        boolean ans = checkAB(s,0);
        System.out.println(ans);
    }
    public static boolean checkAB(String ques,int start){
        if(ques.charAt(start) == '\0')
            return true;
        if(ques.charAt(start) != 'a')
            return false;
        if(ques.charAt(start + 1) != '\0' && ques.charAt(start + 2) != '\0') {
            if (ques.charAt(start + 1) == 'b' && ques.charAt(start + 2) == 'b') {
                return checkAB(ques, start + 3);
            }
        }
        return checkAB(ques,start + 1);
    }
}
