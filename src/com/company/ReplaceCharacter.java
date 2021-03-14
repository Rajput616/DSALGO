package com.company;

import java.util.Scanner;

public class ReplaceCharacter {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String st = s.next();
        char c1 = s.next().charAt(0);
        char c2 = s.next().charAt(0);
        String ans = repCharacter(st, c1, c2, "");
        System.out.println(ans);
    }
    public static String repCharacter(String st , char c1,char c2, String psf){
        if(st.length() == 0) {
            return psf;
        }
        char ch = st.charAt(0);
        String roq = st.substring(1);
        String ans;
        if(c1 == ch){
            ans = repCharacter(roq,c1,c2,psf + c2);
        }
        else{
            ans = repCharacter(roq,c1,c2,psf + ch);
        }
        return ans;

    }
}
