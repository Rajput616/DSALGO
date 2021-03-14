package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ReturnKpc {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String st = s.next();
        ArrayList<String> ans = retKPC(st);
        System.out.println(ans);
    }
    static String[] codes = {",.","abc","def","ghi","jkl","mno","pqr","st","uvw","xyz"};
    public static ArrayList<String> retKPC(String st){
        if(st.length() == 0){
            ArrayList<String> bcase = new ArrayList<>();
            bcase.add("");
            return bcase;
        }
        char ch = st.charAt(0);
        String roq = st.substring(1);
        ArrayList<String> rres = retKPC(roq);
        ArrayList<String> mres = new ArrayList<>();
        String code = codes[ch - '0'];
        for(int i = 0; i < code.length(); i++) {
            char ch1 = code.charAt(i);
            for (String rstr : rres) {
                mres.add(ch1 + rstr);
            }
        }
        return mres;
    }

}

