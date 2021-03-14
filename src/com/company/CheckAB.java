package com.company;

import java.util.Scanner;

public class CheckAB {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String ques = scn.next();
        boolean ans = checkAB(ques);
        System.out.println(ans);
    }

    public static boolean checkAB(String ques) {
        if(ques.length() == 0)
        {
            return true;
        }
        if(ques.charAt(0) == 'a')
        {
            String s = ques.substring(1);
            if(s.length() > 1) {
                String s1 = ques.substring(1, 3);
                if (s1.equals("bb")) {
                    return checkAB(ques.substring(3));
                } else {
                    return checkAB(s);
                }
            }
            else
                return checkAB(s);
        }
        return false;
    }
}

