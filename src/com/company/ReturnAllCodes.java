package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class ReturnAllCodes {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.next();
        ArrayList<String> ans = ReturnCodes(s,"");
        System.out.println(ans);
    }
    public static ArrayList<String> ReturnCodes(String s, String asf) {
        ArrayList<String> rres = new ArrayList<>();
        ArrayList<String> rres12 = new ArrayList<>();
        if(s.length() == 0) {
//            System.out.println(asf);
            ArrayList<String> bcase = new ArrayList<>();
            bcase.add(asf);
            return bcase;
        }
        else if(s.length() == 1) {
            char ch = s.charAt(0);
            if(ch == '0') {
                return new ArrayList<>();
            }
            else {
                int chv = ch - '0';
                char code = (char)('a' + chv - 1);
                ArrayList<String> bcase = new ArrayList<>();
                bcase.add(asf+code);
                return bcase;
            }
        }
        else {
            char ch = s.charAt(0);
            String roq = s.substring(1);
            if(ch == '0') {
                return new ArrayList<>();
            }
            else {
                int chv = ch - '0';
                char code = (char)('a' + chv - 1);
                rres = ReturnCodes(roq,asf + code);
            }
            String st12 = s.substring(0,2);
            String roq12 = s.substring(2);

            int chv = Integer.parseInt(st12);
            if(chv<=26) {
                char code = (char)('a' + chv -1);
                rres12 = ReturnCodes(roq12,asf + code);
            }
        }
        ArrayList<String> mes = new ArrayList<>();
        mes.addAll(rres);
        mes.addAll(rres12);
        return mes;
    }
}
