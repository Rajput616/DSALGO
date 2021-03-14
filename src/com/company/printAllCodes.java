package com.company;

import java.util.Scanner;

public class printAllCodes {
    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        String st = s.next();
        prtAllCodes(st, "");
    }
    public static void prtAllCodes(String st, String asf) {
        if(st.length() == 0){
            System.out.println(asf);
        }
        else if(st.length() == 1){
            char ch = st.charAt(0);
            if(ch == '0') {
                return;
            }
            else{
                int chv = ch - '0';
                char code = (char)('a' + chv - 1);
                System.out.println(asf + code);
            }
        }
        else {
            char ch = st.charAt(0);
            if(ch == '0'){
                return;
            }
            else{
                int chv = ch - '0';
                char code = (char)( 'a' + chv - 1);
                String roq = st.substring(1);
                prtAllCodes( roq, asf + code );
            }
            String ch12 = st.substring(0,2);
            int ch12v = Integer.parseInt(ch12);
            if(ch12v <= 26){
                String roq = st.substring(2);
                char code = (char)('a' + ch12v - 1);
                prtAllCodes(roq , asf + code);
            }
        }
    }
}
