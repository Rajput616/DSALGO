package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class NewReturnPermutations {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String st = s.next();
        ArrayList<String> ans = rtrnPermutations(st , "");
        System.out.println(ans);
    }
    public static ArrayList<String> rtrnPermutations(String st , String asf) {
        if(st.length() == 0) {
            ArrayList<String> bcase = new ArrayList<>();
            bcase.add(asf);
            return bcase;
        }
        ArrayList<String> mres = new ArrayList<>();
        for(int i = 0; i < st.length(); i++){
            char ch = st.charAt(i);
            String left = st.substring(0,i);
            String right = st.substring(i + 1);
            String roq = left + right;
            ArrayList<String> rres = rtrnPermutations(roq, asf + ch);
            mres.addAll(rres);
        }
        return mres;
    }
}
