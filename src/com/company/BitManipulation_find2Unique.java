package com.company;

public class BitManipulation_find2Unique {
    public static void main(String[] args) {
        int[] arr ={1, 2, 3, 4, 5, 1, 2, 3, 5, 8};
        unique2(arr, 10);
    }
    public static void unique2(int[] arr, int n){
        int xorSum = 0;
        for(int i = 0; i < n; i++){
            xorSum = xorSum ^ arr[i];
        }
        int tempXor = xorSum;
        int setBit = 0, pos = 0;
        while(setBit != 1){
            setBit = xorSum & 1;
            pos++;
            xorSum = xorSum >> 1;
        }
        int newXor = 0;
        for(int i = 0; i < n ; i++){
            if(getBit(arr[i], pos - 1)){
                newXor = newXor ^ arr[i];
            }
        }
        System.out.println(newXor + " " + (tempXor ^ newXor));
    }
    public static boolean getBit(int n ,int pos){
        return ((n & (1 << pos))!=0);
    }
}
