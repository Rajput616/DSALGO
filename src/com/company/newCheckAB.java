package com.company;

import java.util.Scanner;

public class newCheckAB {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String st = s.next();
        boolean ans = checkab(st);
        System.out.println(ans);
    }
    public static boolean checkab(String st) {
        if(st.length() == 0)
            return true;
        if(st.charAt(0) == 'a')
        {
            if(st.substring(1).length() > 1 && st.substring(1,3).equals("bb")){
                return checkab(st.substring(3));
            }
            else
                return checkab(st.substring(1));

        }
        return false;
    }
}
