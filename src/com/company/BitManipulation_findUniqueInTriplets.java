package com.company;


public class BitManipulation_findUniqueInTriplets {
    public static void main(String[] args) {
        int[] arr ={1, 2, 3, 1, 2, 3, 1, 2, 3, 4};
        int val = unique3(arr, 10);
        System.out.println (val);
    }
    public static int  unique3(int[] arr, int n){
        int result = 0;
        for(int i = 0; i < 64; i++){
            int sum = 0;
            for(int j = 0; j < n; j++){
                if(getBit(arr[j], i)){
                    sum++;
                }
            }
            if(sum % 3 != 0){
                result = setBit(result, i);
            }
        }
        return result;

    }
    public static boolean getBit(int n, int pos){
        return ((n & (1 << pos)) != 0);
    }
    public static int setBit(int n ,int pos){
        return (n | (1 << pos));
    }
}
