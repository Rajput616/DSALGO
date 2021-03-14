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
        ArrayList<String> ans = returnSubsets(arr,0,"");
        for(String s : ans){
            System.out.println(s);
        }
    }
    public static ArrayList<String> returnSubsets(int[] arr, int idx, String set){
        if(idx == arr.length)
        {
            ArrayList<String> bcase = new ArrayList<>();
            bcase.add(set);
            return bcase;
        }

        ArrayList<String> ans1 = returnSubsets(arr,idx + 1,set);
        ArrayList<String> ans2 = returnSubsets(arr,idx + 1, set + arr[idx] + " ");

        ArrayList<String> mres = new ArrayList<>();
        for(String sans1 : ans1)
            mres.add(sans1);
        for(String sans2 : ans2)
            mres.add(sans2);
        return mres;
    }
}