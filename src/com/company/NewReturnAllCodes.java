package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class NewReturnAllCodes {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String st = s.next();
        ArrayList<String> ans = rtrnallCodes(st, "");
        System.out.println(ans);
    }
    public static ArrayList<String> rtrnallCodes(String st, String asf) {
        ArrayList<String> rres;
        ArrayList<String> rres12 = new ArrayList<>();
        ArrayList<String> mres = new ArrayList<>();
        if(st.length() == 0){
            ArrayList<String> bcase = new ArrayList<>();
            bcase.add("");
            return bcase;
        }
        else if(st.length() == 1){
            char ch = st.charAt(0);
            if(ch == '0')
                return new ArrayList<>();
            else {
                int chv = ch - '0';
                char code =(char)('a' + chv - 1);
                ArrayList<String> bcase = new ArrayList<>();
                bcase.add(asf + code);
                return bcase;
            }
        }
        else
        {
            char ch = st.charAt(0);
            if(ch == '0')
                return new ArrayList<>();
            else {
                int chv = ch - '0';
                char code =(char)('a' + chv - 1);
                String roq = st.substring(1);
                rres = rtrnallCodes(roq , asf + code);
            }
            String ch12 = st.substring(0,2);
            int ch12v = Integer.parseInt(ch12);
            if(ch12v <= 26) {
                String roq = st.substring(2);
                char code = (char)('a' + ch12v - 1);
                rres12 = rtrnallCodes(roq , asf + code);
            }
        }
        mres.addAll(rres);
        mres.addAll(rres12);
        return mres;
    }
}
