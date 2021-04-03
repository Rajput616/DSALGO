package com.company;

public class BitManipulation_printSubsets {
    public static void main(String[] args) {
        char[] arr= {'a', 'b', 'c', 'd'};
        subsets (arr ,4);
    }
    public static void subsets(char[] arr, int n){
        for(int i = 0; i < (1 << n); i++){
            for(int j = 0; j < n; j++){
                if((i & (1<<j)) != 0){
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println();
        }
    }
}
