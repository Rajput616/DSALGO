package com.company;

import java.util.*;

public class common_String{

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String[] str = new String[n*2];
        for(int i = 0; i < n*2; i += 2){
            str[i] = scn.next();
            str[i+1] = scn.next();
        }
        for(int i = 0;i < n*2; i += 2 ){
            String ans = common_Substring(str[i] , str[i + 1]);
            System.out.println(ans);
        }
    }

    public static String common_Substring(String s1, String s2){
        for(int i = 0; i < s1.length(); i++){
            for(int j = 0; j < s2.length(); j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    return "YES";
                }
            }
        }
        return "NO";
    }
}