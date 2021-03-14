package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class ReturnPermutations {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String ques = scn.next();
        ArrayList<String> permutations = returnPermutations(ques, "");
        System.out.println(permutations);
    }
    public static ArrayList<String> returnPermutations(String ques,String asf){
        if(ques.length() == 0)
        {
            ArrayList<String> bcase = new ArrayList<>();
            bcase.add(asf);
            return bcase;
        }
//        ArrayList<String> rres = new ArrayList<>();
        ArrayList<String> mres = new ArrayList<>();
        for(int i = 0; i < ques.length(); i++)
        {
            char ch = ques.charAt(i);
            String lp = ques.substring(0,i);
            String rp = ques.substring(i+1);
            String roq = lp + rp;
            ArrayList<String> rres = returnPermutations(roq,asf + ch);
           mres.addAll(rres);

        }
        return mres;
    }
}
