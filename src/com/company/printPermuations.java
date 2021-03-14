package com.company;

import java.util.Scanner;

public class printPermuations {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        permutations(s,"");
    }
    public static void permutations(String ques , String asf){
        if(ques.length() == 0)
            System.out.println(asf);
        for(int i = 0; i < ques.length(); i++)
        {
            char ch = ques.charAt(i);
            String lp = ques.substring(0,i);
            String rp = ques.substring(i+1);
            String roq = lp + rp;
            permutations(roq,asf+ch);
        }

    }
}
