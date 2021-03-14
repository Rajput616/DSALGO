package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class returnSubsetsARRAY {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i =0; i < arr.length; i++){
            arr[i] = s.nextInt();
        }
        ArrayList<String> ans = rtrnSubsetsARR(arr,0);
        System.out.println(ans);
    }
    public static ArrayList<String> rtrnSubsetsARR(int[] arr, int idx) {
        if(idx == arr.length){
            ArrayList<String> bcase = new ArrayList<>();
            bcase.add("");
            return bcase;
        }
        int fv = arr[idx];
        ArrayList<String> rres1 = rtrnSubsetsARR(arr,idx + 1);
        ArrayList<String> mres = new ArrayList<>();
        for(String rstr : rres1){
            mres.add("" + rstr);
        }for(String rstr : rres1){
            mres.add(fv + rstr);
        }
        return mres;
    }
}
