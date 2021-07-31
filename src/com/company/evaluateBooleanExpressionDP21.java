package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class evaluateBooleanExpressionDP21 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String exp = scn.next();
        int noOfEvaluation = evaluateBooleanExpression(exp, 0, exp.length()-1, true);
        System.out.println(noOfEvaluation);
    }
    public static HashMap<String, Integer> hm = new HashMap<>();

    public static int evaluateBooleanExpression(String exp, int i, int j, boolean isTrue){
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
        if(hm.containsKey(i + " " + j + " " + isTrue)){
            return hm.get(i + " " + j + " " + isTrue);
        }
        int ans = 0;
        for(int k = i+1; k < j; k += 2){
            int lt = evaluateBooleanExpression(exp, i, k-1, true);
            int lf = evaluateBooleanExpression(exp, i, k-1, false);
            int rt = evaluateBooleanExpression(exp, k+1, j, true);
            int rf = evaluateBooleanExpression(exp, k+1, j, false);
            if(exp.charAt(k) == '&'){
                if(isTrue){
                    ans += lt * rt;
                } else{
                    ans += lt * rf + lf * rt + lf * rf;
                }
            } else if(exp.charAt(k) == '|'){
                if(isTrue){
                    ans += lt * rt + lt * rf + lf * rt;
                } else{
                    ans += lf * rf;
                }
            } else{
                if(isTrue){
                    ans += lf * rt + lt * rf;
                } else{
                    ans += lt * rt + lf * rf;
                }
            }
        }
        hm.put(i + " " + j + " "+ isTrue, ans);
        return ans;
    }

}
