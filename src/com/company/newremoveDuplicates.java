package com.company;

import java.util.Scanner;

public class newremoveDuplicates {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String st = s.next();
        String ans =  remDuplicates(st , "");
        System.out.println(ans);
    }
    public static String remDuplicates(String st ,String ssf){
        if(st.length() == 1)
            return ssf+st;
        String roq = st.substring(1);
        String ans;
        if(st.charAt(0) != st.charAt(1))
            ans = remDuplicates(roq,ssf + st.charAt(0));
        else
            ans = remDuplicates(roq, ssf);
        return ans;
    }
}
