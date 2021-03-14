package com.company;

import java.util.Scanner;

public class ActualSoln {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        boolean ans = checkAB(s);
        System.out.println(ans);
    }

    public static boolean checkAB(String ques) {
        if(ques.length() == 0){
            return  true;
        }
        if(ques.charAt(0) == 'a') {
            if (ques.substring(1).length() > 1 && ques.substring(1, 3).equals("bb")) {
                return checkAB(ques.substring(3));
            } else {
                return checkAB(ques.substring(1));
            }
        }

        return false;
    }
}
