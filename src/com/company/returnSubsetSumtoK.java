package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class returnSubsetSumtoK {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = s.nextInt();
        }
        int k = s.nextInt();
        ArrayList<String> ans = rtnsubsetsumtoK(arr,0,k,0,"");
        System.out.println(ans);
    }
    public static ArrayList<String> rtnsubsetsumtoK(int[] arr, int idx, int k, int sos, String asf) {
        if(idx == arr.length)
        {
            ArrayList<String> bcase = new ArrayList<>();
            if(sos == k)
                bcase.add(asf);
            return bcase;
        }
        ArrayList<String> rres1 = rtnsubsetsumtoK(arr, idx + 1,k,sos,asf);
        ArrayList<String> rres2 = rtnsubsetsumtoK(arr, idx + 1,k,sos + arr[idx],asf + arr[idx] + " ");
        ArrayList<String> mres = new ArrayList<>();
        mres.addAll(rres1);
        mres.addAll(rres2);
        return mres;
     }
}
