package com.company;

import java.util.Scanner;

public class printSubsetArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
        prtSubsetArray(arr,0,"");
    }
    public static void prtSubsetArray(int[] arr, int idx, String asf) {
        if(idx == arr.length){
            System.out.println(asf);
            return;
        }
        prtSubsetArray(arr, idx + 1, asf);
        prtSubsetArray(arr, idx + 1, asf + arr[idx] + " ");
    }
}
