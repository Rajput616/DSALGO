package com.company;

import java.util.Scanner;

public class BooleanParenthesis {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String exp = scn.next();
        int ans = boolParenthesis(exp, 0, exp.length()-1, true);
        System.out.println(ans);
    }
    public static int boolParenthesis(String exp, int i, int j, boolean isTrue){

        if(i > j){
            return 0;
        }
        if(i == j){
            if(isTrue){
                return exp.charAt(i) == 'T' ? 1 : 0;
            }else{
                return exp.charAt(i) == 'F' ? 1 : 0;
            }
        }
        int ans = 0;

        for(int k = i+1; k < j; k+=2){
            int leftTrue = boolParenthesis(exp, i ,k-1,true);
            int leftFalse = boolParenthesis(exp, i ,k-1,false);
            int rightTrue = boolParenthesis(exp, k+1 ,j,true);
            int rightFalse = boolParenthesis(exp, k+1 ,j,false);
            if(exp.charAt(k) == '|'){
                if(isTrue){
                    ans += leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
                }else{
                    ans += leftFalse * rightFalse;
                }
            }else if(exp.charAt(k) == '&'){
                if(isTrue){
                    ans += leftTrue * rightTrue;
                }
                else{
                    ans += leftFalse * rightTrue + leftTrue * rightFalse + leftFalse * rightFalse;
                }
            }else{
                if(isTrue){
                    ans += leftTrue * rightFalse + leftFalse * rightTrue;
                }else{
                    ans += leftFalse * rightFalse + leftTrue * rightTrue;
                }
            }
        }
        return ans;
    }
}
