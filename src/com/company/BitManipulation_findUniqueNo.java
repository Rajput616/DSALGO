package com.company;

public class BitManipulation_findUniqueNo {
    public static void main(String[] args) {
        int[] arr ={1, 2, 3, 4, 5, 1, 2, 3, 5};
        unique(arr, 9);
    }
    public static void unique(int[] arr, int n){
        int xorSum = 0;
        for(int i = 0; i < n ; i++){
            xorSum = xorSum ^ arr[i];
        }
        System.out.println (xorSum);
    }
}
