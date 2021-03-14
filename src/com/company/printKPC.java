package com.company;

import java.util.Scanner;

public class printKPC {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String st = s.next();
        prtKPC(st,"");
    }
    static String[] codes = {",.","abc","def","ghi","jkl","mno","pqr","st","uvw","xyz"};
    public static void prtKPC(String st , String asf) {
        if(st.length() == 0){
            System.out.println(asf);
            return;
        }
        char ch = st.charAt(0);
        String roq = st.substring(1);
        String code = codes[ch - '0'];
        for(int i = 0; i < code.length(); i++){
            char ch1 = code.charAt(i);
            prtKPC(roq, asf + ch1);
        }
    }
}
