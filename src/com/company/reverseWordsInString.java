package com.company;

import java.util.Scanner;



public class reverseWordsInString {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();

            System.out.println(reverseWords(s));
            t--;
        }
    }
    public static String reverseWords(String S) {
        String[] words = S.split("[.]");
        String ans = "";
        for(int i = words.length-1; i >= 0; i--){
            if(ans.equals("")){
                ans += words[i];
            } else{
                ans += "." + words[i];
            }
        }
        return ans;
    }
}
