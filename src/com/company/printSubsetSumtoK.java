package com.company;

import java.util.Scanner;

public class printSubsetSumtoK {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
        int k = s.nextInt();
        prtSubsetSumtoK(arr,0,k,0,"");
    }
    public static void prtSubsetSumtoK(int[] arr, int idx, int k, int sos, String asf) {
        if(idx == arr.length){
            if(sos == k){
                System.out.println(asf);
            }
            return;
        }
        prtSubsetSumtoK(arr,idx + 1, k, sos, asf);
        prtSubsetSumtoK(arr,idx + 1, k, sos + arr[idx], asf + arr[idx] + " ");
    }
}
