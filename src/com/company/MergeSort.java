package com.company;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = s.nextInt();
        }
        int[] ms = mergeSort(arr , 0, arr.length - 1);
        for(int m : ms) {
            System.out.print(m + " ");
        }
    }
    public static int[] mergeSort(int[] arr, int low , int high){
        if(low == high) {
            int[] barr = new int[1];
            barr[0] = arr[low];
            return barr;
        }
        int mid = (low + high) / 2;
        int[] ls = mergeSort(arr, low, mid);
        int[] rs = mergeSort(arr, mid + 1, high);
        int i,j,k;
        i = j = k = 0;
        int[] ans = new int[ls.length + rs.length];
        while(i < ls.length && j < rs.length) {
            if(ls[i] < rs[j]) {
                ans[k] = ls[i];
                i++;
            }
            else {
                ans[k] = rs[j];
                j++;
            }
            k++;
        }
        while(i < ls.length){
            ans[k] = ls[i];
            i++;
            k++;
        }
        while(j < rs.length){
            ans[k] = rs[j];
            j++;
            k++;
        }
        return ans;
    }
}
