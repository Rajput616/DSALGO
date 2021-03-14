package com.company;

import java.util.Scanner;

public class removeDuplicates {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        String ans = removeConsecutiveDuplicates(s);
        System.out.println(ans);

    }
    public static String removeConsecutiveDuplicates(String s) {
        if(s.length() <= 1) {
            return s;
        }
        char ch = s.charAt(0);
        String mres = "";
        String ans;
        String roq = s.substring(1);
        if(s.charAt(0) != s.charAt(1)) {
            mres = mres + ch;
            ans = removeConsecutiveDuplicates(roq);
        }
        else
            ans = removeConsecutiveDuplicates(roq);
        mres = mres + ans;
        return mres;

    }
}
