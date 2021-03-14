package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int  i = 0; i<arr.length; i++)
            arr[i] = scn.nextInt();
        int target = scn.nextInt();
        ArrayList<String> ans = returnSubsets(arr,0,"",0,target);
        for(String s : ans){
            System.out.println(s);
        }
    }
    public static ArrayList<String> returnSubsets(int[] arr, int idx, String set,int sos,int target){
        if(idx == arr.length)
        {
            ArrayList<String> bcase = new ArrayList<>();
            if(sos == target) {
                bcase.add(set);
            }
            return bcase;
        }

        ArrayList<String> ans1 = returnSubsets(arr,idx + 1,set , sos ,target);
        ArrayList<String> ans2 = returnSubsets(arr,idx + 1, set + arr[idx] + " ",arr[idx] + sos,target);

        ArrayList<String> mres = new ArrayList<>();
        mres.addAll(ans1);
        mres.addAll(ans2);
        return mres;
    }
}