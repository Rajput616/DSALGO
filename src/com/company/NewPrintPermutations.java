package com.company;

import java.util.Scanner;

public class NewPrintPermutations {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String st = s.next();
        prtPermutations(st, "");
    }
    public static void prtPermutations(String st, String asf) {
        if(st.length() == 0){
            System.out.println(asf);
        }
        for(int i = 0; i < st.length(); i++){
            char ch = st.charAt(i);
            String left = st.substring(0,i);
            String right = st.substring(i + 1);
            String roq = left + right;
            prtPermutations(roq , asf + ch);
        }
    }
}
